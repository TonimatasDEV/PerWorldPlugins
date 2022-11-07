package net.tonimatasdev.perworldplugins.util;

import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class FieldUtils {
    public static Field getField(Class<?> cls, String fieldName, boolean forceAccess) {
        Validate.notNull(cls, "cls");
        Validate.isTrue(StringUtils.isNotBlank(fieldName), "The field name must not be blank/empty");

        for (Class<?> acls = cls; acls != null; acls = acls.getSuperclass()) {
            try {
                Field field = acls.getDeclaredField(fieldName);

                if (!Modifier.isPublic(field.getModifiers())) {
                    if (forceAccess) {
                        field.setAccessible(true);
                    } else {
                        continue;
                    }
                }

                return field;
            } catch (NoSuchFieldException ex) {
                Bukkit.getConsoleSender().sendMessage("Error on getField: " + fieldName);
            }
        }

        Field match = null;

        for (Class<?> class1 : ClassUtils.getAllInterfaces(cls)) {
            try {
                Field test = class1.getField(fieldName);

                Validate.isTrue(match == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", fieldName, cls);
                match = test;
            } catch (NoSuchFieldException ex) {
                Bukkit.getConsoleSender().sendMessage("Error on getField: " + fieldName);
            }
        }

        return match;
    }

    private static class Validate {
        private static <T> void notNull(T object, String message, Object... values) {
            Objects.requireNonNull(object, () -> String.format(message, values));
        }

        private static void isTrue(boolean expression, String message, Object... values) {
            if (!expression) throw new IllegalArgumentException(String.format(message, values));
        }
    }

    private static class ClassUtils {
        private static List<Class<?>> getAllInterfaces(Class<?> cls) {
            if (cls == null) return null;

            LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<>();
            getAllInterfaces(cls, interfacesFound);

            return new ArrayList<>(interfacesFound);
        }

        private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> interfacesFound) {
            while (cls != null) {
                Class<?>[] interfaces = cls.getInterfaces();

                for (Class<?> i : interfaces) {
                    if (interfacesFound.add(i)) getAllInterfaces(i, interfacesFound);
                }

                cls = cls.getSuperclass();
            }
        }
    }
}
