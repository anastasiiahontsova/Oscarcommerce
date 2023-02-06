package com.oscarcommerce.utils;

public class User {

    public User(String pwd) {
        this.password = pwd;
        this.email = generateUserEmail();
    }

    public String generateUserEmail(){
        return "testemail@gmail.com";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String email;
    String password;

}
