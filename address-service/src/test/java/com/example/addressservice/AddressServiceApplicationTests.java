package com.example.addressservice;

import com.example.addressservice.model.Address;
import com.example.addressservice.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldGetAddressForPersonName() {
		AddressService addService = new AddressService();
		Address address = addService.getAddress("Sam");
		assertThat(address.getStreet(),is("SomeStreet"));

	}
}
