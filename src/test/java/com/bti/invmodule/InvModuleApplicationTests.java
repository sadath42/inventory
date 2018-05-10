package com.bti.invmodule;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.MockRestServiceServer.MockRestServiceServerBuilder;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.bti.inventory.InvModuleApplication;
import com.bti.inventory.dto.SiteDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes=InvModuleApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class InvModuleApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private RestOperations restOperations;
	

	@Autowired
	private WebApplicationContext wac;
	
	private MockRestServiceServer mockRestServiceServer;
	

	@Autowired
	private ObjectMapper mapper;

	/*
	 * @Mock private RestTemplate restTemplate;
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		 MockRestServiceServerBuilder createServer = MockRestServiceServer.bindTo((RestTemplate)restOperations);
		 createServer.ignoreExpectOrder(true);
		 mockRestServiceServer =createServer.build();
		expectRestCallSuess();
	}
	private void expectRestCallSuess() {
		
		mockRestServiceServer.expect(ExpectedCount.times(2), new Requestcontainsurimatcher("/validate"))
				.andExpect(method(HttpMethod.POST))
				.andRespond(withSuccess(toJson(new ResponseEntity<>(true, HttpStatus.OK)), MediaType.APPLICATION_JSON));		
	}
	
	
	
	private String toJson(Object wrapper) {
		try {
			return mapper.writeValueAsString(wrapper);
		} catch (JsonProcessingException e) {
			Assert.fail("Exception: " + e.getMessage());
		}
		return "";
	}
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateSite() throws Exception {
		SiteDto dto = new SiteDto();
		dto.setSiteID("jod");
		dto.setDescription("test");
		mockMvc.perform(post("/sites").content(toJson(dto)).header("currentUser", 123).header("sessionId", "234").header("compnayTenantId", "asd")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
		
	}
	
	@Test
	public void testCreateSiteValidation() throws Exception {
		SiteDto dto = new SiteDto();
	
		mockMvc.perform(post("/sites").content(toJson(dto)).header("currentUser", 123).header("sessionId", "234").header("compnayTenantId", "asd")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
		
	}
 
	class Requestcontainsurimatcher implements RequestMatcher {
		private final String uri;

		public Requestcontainsurimatcher(String uri) {
			this.uri = uri;
		}

		@Override
		public void match(ClientHttpRequest arg0) throws IOException, AssertionError {
			Assert.assertTrue(arg0.getURI().toString().contains(uri));

		}
	}
}
