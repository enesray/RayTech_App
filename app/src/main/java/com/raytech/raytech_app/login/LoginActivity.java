package com.raytech.raytech_app.login;

import static com.raytech.raytech_app.util.LoginUtils.LoginUserInputValidator;
import static com.raytech.raytech_app.util.Utils.ChangeActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.raytech.raytech_app.MainActivity;
import com.raytech.raytech_app.R;

public class LoginActivity extends AppCompatActivity {
    String userEmailTxt, userPasswordTxt;
    TextView userEmail, userPassword;
    LinearLayout registerLayout;
    LoginUserModel loginUserModel;
    LoginManager loginManager;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        init();
        events();
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginManager.signInExistingUser(LoginActivity.this, MainActivity.class);
    }

    private void init() {
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        registerLayout = findViewById(R.id.registerLayout);
        loginManager = new LoginManager(context);
        loginUserModel = new LoginUserModel(userEmailTxt, userPasswordTxt);
    }

    private void events() {
        registerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeActivity(LoginActivity.this, RegisterActivity.class);
            }
        });
    }

    public void userLoginButton(View view) {
        userEmailTxt = userEmail.getText().toString();
        userPasswordTxt = userPassword.getText().toString();

        loginUserModel = new LoginUserModel(userEmailTxt, userPasswordTxt);
        if (LoginUserInputValidator(loginUserModel, context)) {
            loginManager.sigIn(loginUserModel, LoginActivity.this, MainActivity.class);
        }
    }
}

