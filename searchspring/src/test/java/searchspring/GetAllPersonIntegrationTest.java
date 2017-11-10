package searchspring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GetAllPersonIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private SearchController searchController;
		
	@Autowired
	private PersonService personService;
	
	
	@Test
	public void addPersonTest() throws Exception {
		personService.addPerson(new Person("addedFromTest2"));
		assertEquals("addedFromTest2", personService.findPerson("addedFromTest2").getName());
		personService.deletePerson("addedFromTest2");
	}
	
	@Test
	public void deletePersonTest() throws Exception {
		personService.addPerson(new Person("addedFromTest3"));
		personService.deletePerson("addedFromTest3");
		personService.findPerson("addedFromTest3");
		assertNull(personService.findPerson("addedFromTest2"));
		
	}
	
	
}
