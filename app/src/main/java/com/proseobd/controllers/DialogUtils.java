package com.proseobd.controllers;

import android.app.AlertDialog;
import android.content.Context;

public class DialogUtils {
    // Public static method to show an AlertDialog
    public static void showAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

