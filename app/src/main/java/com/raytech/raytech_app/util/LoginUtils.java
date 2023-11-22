package com.raytech.raytech_app.util;

import android.content.Context;
import android.widget.Toast;
import com.raytech.raytech_app.R;
import com.raytech.raytech_app.login.LoginUserModel;

public class LoginUtils {

    //Login user control
   public static boolean LoginUserInputValidator(LoginUserModel loginUserModel,Context context) {
        if (Utils.IsNullOrEmpty(loginUserModel.getUserEmail()) || Utils.IsNullOrEmpty(loginUserModel.getUserPassword())) {
            Toast.makeText(context , R.string.login_user_and_password_warning, Toast.LENGTH_SHORT).show();
            return false;
        } else if (loginUserModel.getUserPassword().length() < 6) {
            Toast.makeText(context ,R.string.login_password_lenght_warning, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
