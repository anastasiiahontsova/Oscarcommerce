package com.oscarcommerce.utils;

import java.util.ArrayList;

public class User {


    String email;
    String password;
    String name;
    String lastName;
    private ArrayList<ShippingAddress> shippingAddressesList;

    public User(String pwd) {
        this.password = pwd;
        this.email = generateUserEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addShippingAddress(String name, String lastName, String firstLineAddress, String city, String postcode) {
        shippingAddressesList.add(new ShippingAddress(name, lastName, firstLineAddress, city, postcode));
    }

    public ShippingAddress getShippingAddresses(int idx) {
        return shippingAddressesList.get(idx);
    }

    public String generateUserEmail() {
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
