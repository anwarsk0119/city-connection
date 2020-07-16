package com.mc.connection;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class CityConnectionTest extends CityConnectionAbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void checkIfConnectedBoston2Newark() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Boston").param("destination", "Newark"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("yes", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void isConnectedBoston2Philadelphia() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Boston").param("destination", "Philadelphia"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("yes", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void isConnectedPhiladelphia2Albany() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Albany"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("no", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void isConnectedPhiladelphia2Philadelphia() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Philadelphia"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("no", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void notFound() throws Exception {
		String uri = "/connectd";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Albany"))
				.andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
	}

	@Test
	public void isConnectedT2B() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Trenton").param("destination", "Boston"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("no", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void badRequest() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("orgin", "Trenton").param("destination", "Boston"))
				.andReturn();

		assertEquals(400, mvcResult.getResponse().getStatus());
	}

}