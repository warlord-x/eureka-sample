package com.example.addressservice.service;

import com.example.addressservice.model.Address;

public class AddressService {
    public Address getAddress(String personName) {
        return new Address("SomeStreet");
    }
}
