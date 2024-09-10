package dev.tonimatas.perworldplugins.util;

import java.util.Locale;

public class Why {
    public static String whyPlugin(String value) {
        if (value.equals("ServersNPC")) {
            value = "znpcs";
        }
        
        return value.toLowerCase(Locale.ENGLISH);
    }
}
