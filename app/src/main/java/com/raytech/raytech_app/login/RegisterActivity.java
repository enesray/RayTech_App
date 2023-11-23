package com.raytech.raytech_app.login;

import static com.raytech.raytech_app.util.LoginUtils.RegisterUserInputValidator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.raytech.raytech_app.MainActivity;
import com.raytech.raytech_app.R;


public class RegisterActivity extends AppCompatActivity {
    String userNameAndSurNameTxt,userPhoneNumberTxt,userEmailTxt, userPasswordTxt;
    TextView userNameAndSurName,userPhoneNumber,userEmail, userPassword;
    RegisterUserModel registerUserModel;
    LoginManager loginManager;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        init();
        events();
    }

    private void init() {
        userNameAndSurName = findViewById(R.id.userNameAndSurname);
        userPhoneNumber = findViewById(R.id.userPhoneNumber);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        loginManager = new LoginManager(context);
    }

    private void events() {

    }

    public void userRegisterButton(View view) {
        userNameAndSurNameTxt = userNameAndSurName.getText().toString();
        userPhoneNumberTxt = userPassword.getText().toString();
        userEmailTxt = userEmail.getText().toString();
        userPasswordTxt = userPassword.getText().toString();

        registerUserModel = new RegisterUserModel(userNameAndSurNameTxt,userPhoneNumberTxt,userEmailTxt, userPasswordTxt);
        if (RegisterUserInputValidator(registerUserModel, context)) {
            loginManager.signUp(registerUserModel, RegisterActivity.this, MainActivity.class);
        }
    }

}
