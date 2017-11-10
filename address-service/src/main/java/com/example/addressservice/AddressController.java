package com.example.addressservice;

import com.example.addressservice.model.Address;
import com.example.addressservice.service.AddressService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @RequestMapping("/address/{personName}")
    public Address findPersonAddress(@PathVariable String personName) {

        AddressService addService = new AddressService();
        Address address = addService.getAddress("Sam");
        return address;
    }
}
