package com.raytech.raytech_app.login;

import static com.raytech.raytech_app.util.DialogUtils.showPopupDialogError;
import static com.raytech.raytech_app.util.DialogUtils.showPopupDialogSuccess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raytech.raytech_app.R;
import com.raytech.raytech_app.util.Utils;

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
                        showPopupDialogSuccess(activity, R.string.login_success_dialog_description, activity, targetClass);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception error) {
                        showPopupDialogError(activity, R.string.onfailure__dialog_description);
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

                        if (Utils.IsNullOrEmpty(registerUserModel.getUserNameAndSurName()) || Utils.IsNullOrEmpty(registerUserModel.getUserPhoneNumber()) || Utils.IsNullOrEmpty(registerUserModel.getUserEmail()) || Utils.IsNullOrEmpty(registerUserModel.getUserPassword())) {
                            showPopupDialogError(activity, R.string.onfailure__dialog_description);
                            return;
                        }
                        mData.put("userNameAndSurName", registerUserModel.getUserNameAndSurName());
                        mData.put("userPhoneNumber", registerUserModel.getUserPhoneNumber());
                        mData.put("userEmail", registerUserModel.getUserEmail());
                        mData.put("userPassword", registerUserModel.getUserPassword());
                        mData.put("userUid", mUser.getUid());
                        mRefence.child("users").child(mUser.getUid()).setValue(mData);

                        showPopupDialogSuccess(activity, R.string.register_success_dialog_description, activity, targetClass);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception error) {
                        showPopupDialogError(activity, R.string.onfailure__dialog_description);
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
