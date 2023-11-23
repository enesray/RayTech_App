package com.raytech.raytech_app.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class LoginManager {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mRefence;
    private Context context;
    private HashMap<String, Object> mData;

    public LoginManager(Context context) {
        mAuth = FirebaseAuth.getInstance();
        mRefence = FirebaseDatabase.getInstance().getReference();
        this.context = context;
    }

    public void sigIn(LoginUserModel loginUserModel, Activity activity, Class<?> targetClass) {
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

    public void signUp(RegisterUserModel registerUserModel, Activity activity, Class<?> targetClass) {
        mAuth.createUserWithEmailAndPassword(registerUserModel.getUserEmail(), registerUserModel.getUserPassword())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        mUser = mAuth.getCurrentUser();
                        mData = new HashMap<>();

                        mData.put("userNameAndSurName", registerUserModel.getUserNameAndSurName());
                        mData.put("userPhoneNumber", registerUserModel.getUserPhoneNumber());
                        mData.put("userEmail", registerUserModel.getUserEmail());
                        mData.put("userPassword", registerUserModel.getUserPassword());
                        mData.put("userUid", mUser.getUid());
                        mRefence.child("users").child(mUser.getUid()).setValue(mData);

                        Intent intent = new Intent(activity, targetClass);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        activity.startActivity(intent);
                        activity.finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception error) {
                        Log.e("Error", "Register Fail", error);
                    }
                });
    }

    public void signInExistingUser(Activity activity, Class<?> targetClass) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(activity, targetClass);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public void signOut() {
        mAuth.signOut();
    }
}
