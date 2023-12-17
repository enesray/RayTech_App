package com.raytech.raytech_app.util;

import android.app.Activity;
import android.content.Intent;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

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
    public static void ChangeActivity(Activity activity, Class<?> targetClass) {
        Intent intent = new Intent(activity, targetClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
        activity.finish();
    }

}
