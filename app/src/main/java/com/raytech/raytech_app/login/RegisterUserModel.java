package com.raytech.raytech_app.login;

public class RegisterUserModel {
    private String userNameAndSurName;
    private String userPhoneNumber;
    private String userEmail;
    private String userPassword;

    public RegisterUserModel(String userNameAndSurName, String userPhoneNumber, String userEmail, String userPassword) {
        this.userNameAndSurName = userNameAndSurName;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserNameAndSurName() {
        return userNameAndSurName;
    }

    public void setUserNameAndSurName(String userNameAndSurName) {
        this.userNameAndSurName = userNameAndSurName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
