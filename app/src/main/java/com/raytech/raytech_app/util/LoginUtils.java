package com.raytech.raytech_app.util;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;

import com.raytech.raytech_app.R;
import com.raytech.raytech_app.login.LoginUserModel;
import com.raytech.raytech_app.login.RegisterUserModel;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class LoginUtils {

    //Login user control
    public static boolean LoginUserInputValidator(LoginUserModel loginUserModel, Context context) {
        if (Utils.IsNullOrEmpty(loginUserModel.getUserEmail()) || Utils.IsNullOrEmpty(loginUserModel.getUserPassword())) {
            DialogUtils.showPopupDialogWarning(context, R.string.login_user_and_password_warning);
            return false;
        } else if (loginUserModel.getUserPassword().length() < 6) {
            DialogUtils.showPopupDialogWarning(context, R.string.password_lenght_warning);
            return false;
        }
        return true;
    }

    public static boolean RegisterUserInputValidator(RegisterUserModel registerUserModel, Context context) {
        // 1. Kontrol: Boş alan kontrolü
        if (Utils.IsNullOrEmpty(registerUserModel.getUserNameAndSurName()) ||
                Utils.IsNullOrEmpty(registerUserModel.getUserPhoneNumber()) ||
                Utils.IsNullOrEmpty(registerUserModel.getUserEmail()) ||
                Utils.IsNullOrEmpty(registerUserModel.getUserPassword())) {
            DialogUtils.showPopupDialogWarning(context, R.string.register_all_fields_warning);
            return false;
        }
        // 2. Kontrol: Şifre uzunluğu kontrolü
        if (registerUserModel.getUserPassword().length() < 6) {
            DialogUtils.showPopupDialogWarning(context, R.string.password_lenght_warning);
            return false;
        }

        // 3. Kontrol: Geçerli e-posta kontrolü
        if (!isValidEmail(registerUserModel.getUserEmail())) {
            DialogUtils.showPopupDialogWarning(context, R.string.register_invalid_email_warning);
            return false;
        }

        // 4. Kontrol: Telefon numarası uzunluğu kontrolü
        if (registerUserModel.getUserPhoneNumber().length() < 10) {
            DialogUtils.showPopupDialogWarning(context, R.string.register_phone_number_length_warning);
            return false;
        }

        // 5. Kontrol: Kullanıcı adı uzunluğu kontrolü
        if (registerUserModel.getUserNameAndSurName().length() < 3) {
            DialogUtils.showPopupDialogWarning(context, R.string.register_username_length_warning);
            return false;
        }

        // 6. Kontrol: Telefon numarası sadece rakamlardan oluşmalı
        if (!TextUtils.isDigitsOnly(registerUserModel.getUserPhoneNumber())) {
            DialogUtils.showPopupDialogWarning(context, R.string.register_phone_number_digits_warning);
            return false;
        }

        // 7. Kontrol: Kullanıcı adı ve soyadı içinde özel karakter kontrolü
        if (isAlphaNumeric(registerUserModel.getUserNameAndSurName())) {
            DialogUtils.showPopupDialogWarning(context, R.string.register_username_special_characters_warning);
            return false;
        }

        // 8. Kontrol: Kullanıcı adı ve şifre aynı olmamalı
        if (registerUserModel.getUserNameAndSurName().equals(registerUserModel.getUserPassword())) {
            DialogUtils.showPopupDialogWarning(context, R.string.register_username_password_match_warning);
            return false;
        }
        return true;
    }

    private static boolean isAlphaNumeric(String input) {
        return input.matches("^[a-zA-Z0-9]+$");
    }

    private static boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
