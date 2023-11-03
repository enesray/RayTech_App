package com.raytech.raytech_app.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginManager {
    private FirebaseAuth mAuth;
    private Context context;

    public LoginManager(Context context) {
        mAuth = FirebaseAuth.getInstance();
        this.context = context;
    }

    public void sigIn(LoginUserModel loginUserModel, Activity activity,Class<?> targetClass) {
        mAuth.signInWithEmailAndPassword(loginUserModel.getUserEmail(), loginUserModel.getUserPassword())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent intent = new Intent(activity, targetClass);
                        activity.startActivity(intent);
                        activity.finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception error) {
                        Log.e("Error", "Login Fail", error);
                    }
                });
    }

    public void signOut(){
        mAuth.signOut();
    }
    public void userInfo(TextView textView){
      textView.setText(mAuth.getCurrentUser().getEmail());
    }

}
