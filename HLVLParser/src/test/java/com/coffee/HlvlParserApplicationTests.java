package com.coffee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.coffee.controller.Controller;

//import com.coffee.controller.Controller;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(Controller.class)
@WebAppConfiguration
@ContextConfiguration(classes = HlvlParserApplication.class)
public class HlvlParserApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test() throws Exception {
		String xml = "{\"data\" : \"model empty\\nelements:\\nboolean A\\nboolean B\\nrelations:\\nr1: common(A,B)\"}";

		RequestBuilder request = MockMvcRequestBuilders.post("/coffeeHLVLP/hlvlParser").content(xml)
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String hlvlResponse = "% Autogenerated code form the Coffee framework\n" + "% Author: avillota\n"
				+ "% Variables from elements definitions \n" + "var bool : A ;\n" + "var bool : B ;\n"
				+ "% Variables and constraints from the variability relations definition\n" + "constraint A == true ;\n"
				+ "constraint B == true ;\n" + "% The solving parameters from the parameters files";

		assertEquals(hlvlResponse, response.getContentAsString());
	}

}
