package com.oscarcommerce.utils;

public class User {

    private ShippingAddress shippingAddress;

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }
    public void addShippingAddress(String name, String lastName, String firstLineAddress, String city, String postcode){
        shippingAddress = new ShippingAddress(name, lastName, firstLineAddress, city, postcode);
    }

    String email;
    String password;


    public User(String pwd) {
        this.password = pwd;
        this.email = generateUserEmail();
    }

    public String generateUserEmail(){
        return "mail" + System.currentTimeMillis() + "@mail.com";
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


}
