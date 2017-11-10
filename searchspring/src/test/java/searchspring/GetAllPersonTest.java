package searchspring;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GetAllPersonTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private SearchController searchController;
		
	@Mock
	private PersonService personService;
	
	
	@Before
    public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

        mockMvc = standaloneSetup(searchController).build();
    }
	
	@Test
	public void getAllPersons() throws Exception {
		
		Mockito.when(personService.getAllPersons()).thenReturn(Arrays.asList(new Person("abc")));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/persons").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "[{\"name\":\"abc\"}]";
		
		verify(personService).getAllPersons();
		org.skyscreamer.jsonassert.JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	
}
