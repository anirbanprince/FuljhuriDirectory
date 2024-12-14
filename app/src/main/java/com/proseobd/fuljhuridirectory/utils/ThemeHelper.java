package com.proseobd.fuljhuridirectory.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatDelegate;

public class ThemeHelper {
    private static final String PREFERENCES = "theme_prefs";
    private static final String KEY_DARK_MODE = "dark_mode";

    public static void setDarkMode(Context context, boolean isDarkMode) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        preferences.edit().putBoolean(KEY_DARK_MODE, isDarkMode).apply();
        
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public static boolean isDarkMode(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        return preferences.getBoolean(KEY_DARK_MODE, false);
    }
} 