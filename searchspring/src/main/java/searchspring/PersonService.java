package searchspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {


	
	@Autowired
	PersonRepository personRepository;

	@Autowired
    RestTemplate restTemplate;
	
	public List<Person> getAllPersons(){
		ArrayList<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(persons::add);
		return persons;
	}
	
	public Person findPerson(String name) {
		return personRepository.findOne(name);
	}

	public void addPerson(Person person) {
		personRepository.save(person);
	}

	public void deletePerson(String name) {
		personRepository.delete(name);
	}

    public String getAddress(String personName) {
        ResponseEntity<String> address = restTemplate.exchange("http://address-service/address/" + personName, HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                });
        System.out.print(address.getBody());
        return address.getBody();
    }




}
