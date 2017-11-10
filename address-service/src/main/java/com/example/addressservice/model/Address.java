package com.example.addressservice.model;

public class Address {

    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address(String street) {
        this.street = street;
    }
}
