package com.raytech.raytech_app.util;

import static com.raytech.raytech_app.util.Utils.ChangeActivity;

import android.app.Activity;
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

    public static void showPopupDialogSuccess(Context context, int messageResId, Activity activity, Class<?> targetClass) {
        String message = context.getResources().getString(messageResId);

        PopupDialog.getInstance(context)
                .setStyle(Styles.SUCCESS)
                .setHeading(context.getResources().getString(R.string.success_title))
                .setDescription(message)
                .setCancelable(false)
                .setDismissButtonText(context.getResources().getString(R.string.ok_button))
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onDismissClicked(Dialog dialog) {
                        ChangeActivity(activity, targetClass);
                        dialog.dismiss();
                    }
                });
    }

    public static void showPopupDialogError(Context context, int messageResId) {
        String message = context.getResources().getString(messageResId);

        PopupDialog.getInstance(context)
                .setStyle(Styles.FAILED)
                .setHeading(context.getResources().getString(R.string.error_title))
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

    public static void showPopupDialogYesOrNo(Context context, int messageResId) {
        String message = context.getResources().getString(messageResId);

        PopupDialog.getInstance(context)
                .setStyle(Styles.STANDARD)
                .setHeading(context.getResources().getString(R.string.exit_title))
                .setDescription(message)
                .setCancelable(false)
                .setDismissButtonText(context.getResources().getString(R.string.ok_button))
                .setPositiveButtonText(context.getResources().getString(R.string.yes))
                .setNegativeButtonText(context.getResources().getString(R.string.no))
                .setPopupDialogIcon(R.drawable.exit)

                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onPositiveClicked(Dialog dialog) {

                        super.onPositiveClicked(dialog);
                    }

                    @Override
                    public void onNegativeClicked(Dialog dialog) {
                        super.onNegativeClicked(dialog);
                    }
                });
    }

}
