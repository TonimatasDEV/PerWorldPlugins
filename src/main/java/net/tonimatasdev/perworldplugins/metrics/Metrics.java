package net.tonimatasdev.perworldplugins.metrics;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;

public class Metrics {
    private final Plugin plugin;

    public Metrics(JavaPlugin plugin, int serviceId) {
        this.plugin = plugin;

        File bStatsFolder = new File(plugin.getDataFolder().getParentFile(), "bStats");
        File configFile = new File(bStatsFolder, "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        if (!config.isSet("serverUuid")) {
            config.addDefault("enabled", true);
            config.addDefault("serverUuid", UUID.randomUUID().toString());
            config.addDefault("logFailedRequests", false);
            config.addDefault("logSentData", false);
            config.addDefault("logResponseStatusText", false);
            config.options().setHeader(Arrays.asList("bStats (https://bStats.org) collects some basic information for plugin authors, like how",
                            "many people use their plugin and their total player count. It's recommended to keep bStats",
                            "enabled, but if you're not comfortable with this, you can turn this setting off. There is no",
                            "performance penalty associated with having metrics enabled, and data sent to bStats is fully",
                            "anonymous.")).copyDefaults(true);

            try {
                config.save(configFile);
            } catch (IOException ignored) {

            }
        }

        String serverUUID = config.getString("serverUuid");

        boolean enabled = config.getBoolean("enabled", true);
        boolean logErrors = config.getBoolean("logFailedRequests", false);
        boolean logSentData = config.getBoolean("logSentData", false);
        boolean logResponseStatusText = config.getBoolean("logResponseStatusText", false);

        new MetricsBase("bukkit", serverUUID, serviceId, enabled, this::appendPlatformData, this::appendServiceData, submitDataTask -> Bukkit.getScheduler().runTask(plugin, submitDataTask), plugin::isEnabled, (message, error) -> this.plugin.getLogger().log(Level.WARNING, message, error), (message) -> this.plugin.getLogger().log(Level.INFO, message), logErrors, logSentData, logResponseStatusText);
    }

    private void appendPlatformData(JsonObjectBuilder builder) {
        builder.appendField("playerAmount", getPlayerAmount());
        builder.appendField("onlineMode", Bukkit.getOnlineMode() ? 1 : 0);
        builder.appendField("bukkitVersion", Bukkit.getVersion());
        builder.appendField("bukkitName", Bukkit.getName());
        builder.appendField("javaVersion", System.getProperty("java.version"));
        builder.appendField("osName", System.getProperty("os.name"));
        builder.appendField("osArch", System.getProperty("os.arch"));
        builder.appendField("osVersion", System.getProperty("os.version"));
        builder.appendField("coreCount", Runtime.getRuntime().availableProcessors());
    }

    private void appendServiceData(JsonObjectBuilder builder) {
        builder.appendField("pluginVersion", plugin.getDescription().getVersion());
    }

    private int getPlayerAmount() {
        try {
            Method onlinePlayersMethod = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers");

            return onlinePlayersMethod.getReturnType().equals(Collection.class) ? ((Collection<?>) onlinePlayersMethod.invoke(Bukkit.getServer())).size() : ((Player[]) onlinePlayersMethod.invoke(Bukkit.getServer())).length;
        } catch (Exception e) {
            return Bukkit.getOnlinePlayers().size();
        }
    }

    public static class MetricsBase {
        private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1, task -> new Thread(task, "bStats-Metrics"));
        private static final String REPORT_URL = "https://bStats.org/api/v2/data/%s";
        public static String METRICS_VERSION = "3.0.0";
        private final String platform;
        private final String serverUuid;
        private final int serviceId;
        private final Consumer<JsonObjectBuilder> appendPlatformDataConsumer;
        private final Consumer<JsonObjectBuilder> appendServiceDataConsumer;
        private final Consumer<Runnable> submitTaskConsumer;
        private final Supplier<Boolean> checkServiceEnabledSupplier;
        private final BiConsumer<String, Throwable> errorLogger;
        private final Consumer<String> infoLogger;
        private final boolean logErrors;
        private final boolean logSentData;
        private final boolean logResponseStatusText;
        private final boolean enabled;

        public MetricsBase(String platform, String serverUuid, int serviceId, boolean enabled, Consumer<JsonObjectBuilder> appendPlatformDataConsumer, Consumer<JsonObjectBuilder> appendServiceDataConsumer, Consumer<Runnable> submitTaskConsumer, Supplier<Boolean> checkServiceEnabledSupplier, BiConsumer<String, Throwable> errorLogger, Consumer<String> infoLogger, boolean logErrors, boolean logSentData, boolean logResponseStatusText) {
            this.platform = platform;
            this.serverUuid = serverUuid;
            this.serviceId = serviceId;
            this.enabled = enabled;
            this.appendPlatformDataConsumer = appendPlatformDataConsumer;
            this.appendServiceDataConsumer = appendServiceDataConsumer;
            this.submitTaskConsumer = submitTaskConsumer;
            this.checkServiceEnabledSupplier = checkServiceEnabledSupplier;
            this.errorLogger = errorLogger;
            this.infoLogger = infoLogger;
            this.logErrors = logErrors;
            this.logSentData = logSentData;
            this.logResponseStatusText = logResponseStatusText;

            checkRelocation();

            if (enabled) startSubmitting();
        }

        private static byte[] compress(String str) throws IOException {
            if (str == null) return null;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            try (GZIPOutputStream gzip = new GZIPOutputStream(outputStream)) {
                gzip.write(str.getBytes(StandardCharsets.UTF_8));
            }

            return outputStream.toByteArray();
        }

        private void startSubmitting() {
            Runnable submitTask = () -> {
                if (!enabled || !checkServiceEnabledSupplier.get()) {
                    scheduler.shutdown();
                    return;
                }

                if (submitTaskConsumer != null) {
                    submitTaskConsumer.accept(this::submitData);
                } else {
                    this.submitData();
                }
            };

            long initialDelay = (long) (1000 * 60 * (3 + Math.random() * 3));
            long secondDelay = (long) (1000 * 60 * (Math.random() * 30));

            scheduler.schedule(submitTask, initialDelay, TimeUnit.MILLISECONDS);
            scheduler.scheduleAtFixedRate(submitTask, initialDelay + secondDelay, 1000 * 60 * 30, TimeUnit.MILLISECONDS);
        }

        private void submitData() {
            JsonObjectBuilder baseJsonBuilder = new JsonObjectBuilder();
            JsonObjectBuilder serviceJsonBuilder = new JsonObjectBuilder();

            appendPlatformDataConsumer.accept(baseJsonBuilder);
            appendServiceDataConsumer.accept(serviceJsonBuilder);
            serviceJsonBuilder.appendField("id", serviceId);
            baseJsonBuilder.appendField("service", serviceJsonBuilder.build());
            baseJsonBuilder.appendField("serverUUID", serverUuid);
            baseJsonBuilder.appendField("metricsVersion", METRICS_VERSION);
            JsonObjectBuilder.JsonObject data = baseJsonBuilder.build();

            scheduler.execute(() -> {
                try {
                    sendData(data);
                } catch (Exception e) {
                    if (logErrors) errorLogger.accept("Could not submit bStats metrics data", e);
                }
            });
        }

        private void sendData(JsonObjectBuilder.JsonObject data) throws Exception {
            if (logSentData) infoLogger.accept("Sent bStats metrics data: " + data.toString());

            byte[] compressedData = compress(data.toString());

            String url = String.format(REPORT_URL, platform);
            HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.addRequestProperty("Accept", "application/json");
            connection.addRequestProperty("Connection", "close");
            connection.addRequestProperty("Content-Encoding", "gzip");
            connection.addRequestProperty("Content-Length", String.valueOf(compressedData.length));
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("User-Agent", "Metrics-Service/1");
            connection.setDoOutput(true);

            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.write(compressedData);
            }

            StringBuilder builder = new StringBuilder();

            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                }
            }

            if (logResponseStatusText) infoLogger.accept("Sent data to bStats and received response: " + builder);
        }

        private void checkRelocation() {
            if (System.getProperty("bstats.relocatecheck") == null || !System.getProperty("bstats.relocatecheck").equals("false")) {
                String defaultPackage = new String(new byte[]{'o', 'r', 'g', '.', 'b', 's', 't', 'a', 't', 's'});
                String examplePackage = new String(new byte[]{'y', 'o', 'u', 'r', '.', 'p', 'a', 'c', 'k', 'a', 'g', 'e'});

                if (MetricsBase.class.getPackage().getName().startsWith(defaultPackage) || MetricsBase.class.getPackage().getName().startsWith(examplePackage)) {
                    throw new IllegalStateException("bStats Metrics class has not been relocated correctly!");
                }
            }
        }
    }

    public static class JsonObjectBuilder {
        private StringBuilder builder = new StringBuilder();
        private boolean hasAtLeastOneField = false;

        public JsonObjectBuilder() {
            builder.append("{");
        }

        private static String escape(String value) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);

                switch (c) {
                    case '"':
                        builder.append("\\\"");
                    case '\\':
                        builder.append("\\\\");
                    case '\u000F':
                        builder.append("\\u000").append(Integer.toHexString(c));
                    case '\u001F':
                        builder.append("\\u00").append(Integer.toHexString(c));
                    default:
                        builder.append(c);
                }
            }

            return builder.toString();
        }

        public void appendField(String key, String value) {
            if (value == null) {
                throw new IllegalArgumentException("JSON value must not be null");
            }

            appendFieldUnescaped(key, "\"" + escape(value) + "\"");
        }

        public void appendField(String key, int value) {
            appendFieldUnescaped(key, String.valueOf(value));
        }

        public void appendField(String key, JsonObject object) {
            if (object == null) throw new IllegalArgumentException("JSON object must not be null");


            appendFieldUnescaped(key, object.toString());
        }

        private void appendFieldUnescaped(String key, String escapedValue) {
            if (builder == null) throw new IllegalStateException("JSON has already been built");
            if (key == null) throw new IllegalArgumentException("JSON key must not be null");
            if (hasAtLeastOneField) builder.append(",");

            builder.append("\"").append(escape(key)).append("\":").append(escapedValue);
            hasAtLeastOneField = true;
        }

        public JsonObject build() {
            if (builder == null) throw new IllegalStateException("JSON has already been built");

            JsonObject object = new JsonObject(builder.append("}").toString());
            builder = null;

            return object;
        }

        public static class JsonObject {
            private final String value;

            private JsonObject(String value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return value;
            }
        }
    }
}
