package com.raytech.raytech_app.util;

public class Utils {
    public static boolean IsNullOrEmpty(String value) {
        boolean result = false;

        try {
            if (value == null || value.isEmpty()) {
                result = true;
            }
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
}
