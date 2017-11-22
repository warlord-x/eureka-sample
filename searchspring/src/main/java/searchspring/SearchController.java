package searchspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/persons")
	public List<Person> search() {
		return personService.getAllPersons();
	}
	
	@RequestMapping("/persons/{name}")
	public Person findPerson(@PathVariable String name){
		return personService.findPerson(name);
	}
	@RequestMapping(method=RequestMethod.POST,value="/persons")
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/persons/{name}")
	public void deletePerson(@PathVariable String name) {
		personService.deletePerson(name);
	}

	@RequestMapping("/address/{personName}")
	public String findPersonAddress(@PathVariable String personName, @AuthenticationPrincipal final UserDetails userDetails){
		System.out.println("userDetails::"+userDetails.getUsername());
		userDetails
				.getAuthorities()
				.stream()
				.forEach(System.out::print);
		return personService.getAddress(personName);
	}
}
