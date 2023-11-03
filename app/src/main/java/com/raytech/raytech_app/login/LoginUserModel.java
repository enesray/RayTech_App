package com.raytech.raytech_app.login;

public class LoginUserModel {
    private String userEmail;
    private String userPassword;

    public LoginUserModel(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

}
