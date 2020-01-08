package br.com.stoom.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.stoom.model.Location;
import br.com.stoom.service.LocationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationControllerTest {

	private MockMvc mvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Autowired
	private LocationService locationService;

	@Test
	public void findAll() throws Exception {
		String uri = "/api/v1/location";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();

		JSONObject obj = new JSONObject(content);

		JSONArray geodata = obj.getJSONArray("data");
		List<Location> locations = new Gson().fromJson(geodata.toString(), List.class);
		assertTrue(!locations.isEmpty());

	}

	@Test
	public void createLocation() throws Exception {

		String uri = "/api/v1/location";
		Location location = new Location();
		location.setStreetName("Avenida Affonso Arinos");
		location.setNumber(1001);
		location.setComplement("Casa");
		location.setNeighbourhood("neighbourhood");
		location.setCity("Americana");
		location.setStatel("SP");
		location.setCountry("Brazil");
		location.setZipcode("13474-580");
		String inputJson = new Gson().toJson(location);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);

	}

	@Test
	public void updateLocation() throws Exception {
		String uri = "/api/v1/location/1";
		Location location = new Location();
		location.setNeighbourhood("Neighbourhood UPDATE");
		location.setCity("Campinas");
		location.setStreetName("Avenida Affonso Arinos");
		location.setNumber(1001);
		location.setComplement("Casa");
		location.setStatel("SP");
		location.setCountry("Brazil");
		location.setZipcode("13474-580");

		String inputJson = new Gson().toJson(location);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(204, status);

	}

	@Test
	public void deleteLocation() throws Exception {
		String uri = "/api/v1/location/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

}
