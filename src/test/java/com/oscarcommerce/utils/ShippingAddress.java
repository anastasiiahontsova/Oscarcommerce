package com.oscarcommerce.utils;

public class ShippingAddress {

    String name;
    String lastName;
    String firstLineAddress;
    String city;
    String postcode;

    public ShippingAddress(String name, String lastName, String firstLineAddress, String city, String postcode) {
        this.name = name;
        this.lastName = lastName;
        this.firstLineAddress = firstLineAddress;
        this.city = city;
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstLineAddress() {
        return firstLineAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }


}
