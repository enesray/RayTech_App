package com.raytech.raytech_app.util;

import android.app.Dialog;
import android.content.Context;

import com.raytech.raytech_app.R;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class DialogUtils {
    public static void showPopupDialogWarning(Context context, int messageResId) {
        String message = context.getResources().getString(messageResId);

        PopupDialog.getInstance(context)
                .setStyle(Styles.ALERT)
                .setHeading(context.getResources().getString(R.string.alert_title))
                .setDescription(message)
                .setCancelable(false)
                .setDismissButtonText(context.getResources().getString(R.string.ok_button))
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onDismissClicked(Dialog dialog) {
                        super.onDismissClicked(dialog);
                    }
                });
    }
}
