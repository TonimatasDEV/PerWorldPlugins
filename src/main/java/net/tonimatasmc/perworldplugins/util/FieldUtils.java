package net.tonimatasmc.perworldplugins.util;

import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class FieldUtils {
    public static Field getField(Class<?> cls, String fieldName, boolean forceAccess) {
        Validate.notNull(cls, "cls");

        if (!fieldName.equals("")) {
            throw new IllegalArgumentException("The field name must not be blank/empty");
        }

        for (Class<?> acls = cls; acls != null; acls = acls.getSuperclass()) {
            try {
                Field field = acls.getDeclaredField(fieldName);

                if (!Modifier.isPublic(field.getModifiers())) {
                    if (forceAccess) {
                        field.setAccessible(true);
                    } else {
                        continue;
                    }
                }return field;
            } catch (NoSuchFieldException ex) {
                Bukkit.getConsoleSender().sendMessage("=========================\nError on get " + fieldName + " field.\n=========================");
            }
        }

        Field field = null;

        for (Class<?> class1 : ClassUtils.getAllInterfaces(cls)) {
            try {
                Field class1Field = class1.getField(fieldName);

                if (field != null) {
                    throw new IllegalArgumentException(String.format("Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", fieldName, cls));
                }

                field = class1Field;
            } catch (NoSuchFieldException ex) {
                Bukkit.getConsoleSender().sendMessage("=========================\nError on get " + fieldName + " field.\n=========================");
            }
        }return field;
    }

    public static class Validate {

        @SuppressWarnings("SameParameterValue")
        private static <T> void notNull(T object, String message, Object... values) {
            Objects.requireNonNull(object, () -> String.format(message, values));
        }
    }

    public static class ClassUtils {
        public static List<Class<?>> getAllInterfaces(Class<?> cls) {
            if (cls == null) {
                return null;
            }

            LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<>();
            getAllInterfaces(cls, interfacesFound);

            return new ArrayList<>(interfacesFound);
        }

        private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> interfacesFound) {
            while (cls != null) {
                Class<?>[] interfaces = cls.getInterfaces();

                for (Class<?> i : interfaces) {
                    if (interfacesFound.add(i)) {
                        getAllInterfaces(i, interfacesFound);
                    }
                }

                cls = cls.getSuperclass();
            }
        }
    }
}
