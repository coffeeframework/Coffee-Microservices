package com.coffee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.coffee.controller.Controller;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = Controller.class)
@WebAppConfiguration
@ContextConfiguration(classes = ReasoningApplication.class)
public class ReasoningTest {

	@Autowired
	private MockMvc mockMvc;
	
//	@Test
//	public void contextLoads() throws Exception {
//		String xml = "{\"data\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"no\\\"?>\\n<featureModel>\\n    <properties\\/>\\n    <struct>\\n        <and mandatory=\\\"true\\\" name=\\\"EjemploFeatureIDE\\\">\\n            <and mandatory=\\\"true\\\" name=\\\"HardWare\\\">\\n                <feature name=\\\"TRESGConector\\\"\\/>\\n                <feature mandatory=\\\"true\\\" name=\\\"ScreenResolution\\\"\\/>\\n                <and mandatory=\\\"true\\\" name=\\\"Processors\\\">\\n                    <feature name=\\\"CPU\\\"\\/>\\n                    <feature name=\\\"GPU\\\"\\/>\\n                <\\/and>\\n                <feature mandatory=\\\"true\\\" name=\\\"RAM\\\"\\/>\\n                <feature name=\\\"GPS\\\"\\/>\\n            <\\/and>\\n            <feature name=\\\"VideoCall\\\"\\/>\\n            <feature name=\\\"Task\\\"\\/>\\n            <or name=\\\"Games\\\">\\n                <feature name=\\\"Chess\\\"\\/>\\n                <feature name=\\\"TRESDCarRace\\\"\\/>\\n                <feature name=\\\"Testris\\\"\\/>\\n            <\\/or>\\n        <\\/and>\\n    <\\/struct>\\n    <constraints\\/>\\n    <calculations Auto=\\\"true\\\" Constraints=\\\"true\\\" Features=\\\"true\\\" Redundant=\\\"true\\\" Tautology=\\\"true\\\"\\/>\\n    <comments\\/>\\n    <featureOrder userDefined=\\\"false\\\"\\/>\\n<\\/featureModel>\\n\"}\r\n" + 
//				"";
//		
//		
//		RequestBuilder request = MockMvcRequestBuilders.post("/coffeMP/feature2Hlvl").content(xml).contentType(MediaType.APPLICATION_JSON_VALUE);
//
//		MvcResult result = mockMvc.perform(request).andReturn();
//
//		MockHttpServletResponse response = result.getResponse();
//
//		String hlvlResponse ="model  Auto_generated\n" + 
//				"elements: \n" + 
//				"	boolean Testris\n" + 
//				"	boolean TRESDCarRace\n" + 
//				"	boolean Chess\n" + 
//				"	boolean Games\n" + 
//				"	boolean Task\n" + 
//				"	boolean VideoCall\n" + 
//				"	boolean GPS\n" + 
//				"	boolean RAM\n" + 
//				"	boolean GPU\n" + 
//				"	boolean CPU\n" + 
//				"	boolean Processors\n" + 
//				"	boolean ScreenResolution\n" + 
//				"	boolean TRESGConector\n" + 
//				"	boolean HardWare\n" + 
//				"	boolean EjemploFeatureIDE\n" + 
//				"relations:\n" + 
//				"	r0: common(EjemploFeatureIDE)\n" + 
//				"	r1:decomposition(EjemploFeatureIDE,[HardWare],[1,1])\n" + 
//				"	r2:decomposition(HardWare,[TRESGConector],[0,1])\n" + 
//				"	r3:decomposition(HardWare,[ScreenResolution],[1,1])\n" + 
//				"	r4:decomposition(HardWare,[Processors],[1,1])\n" + 
//				"	r5:decomposition(Processors,[CPU],[0,1])\n" + 
//				"	r6:decomposition(Processors,[GPU],[0,1])\n" + 
//				"	r7:decomposition(HardWare,[RAM],[1,1])\n" + 
//				"	r8:decomposition(HardWare,[GPS],[0,1])\n" + 
//				"	r9:decomposition(EjemploFeatureIDE,[VideoCall],[0,1])\n" + 
//				"	r10:decomposition(EjemploFeatureIDE,[Task],[0,1])\n" + 
//				"	r11:group(Games,[Chess, TRESDCarRace, Testris],[1,*])\n" + 
//				"	r12:decomposition(EjemploFeatureIDE,[Games],[0,1])\n" + 
//				"";
////		System.out.println("RESPONDE STATUS"+response.getStatus());
////		System.out.println("AQUI:" + response.getContentAsString());
//		assertEquals(hlvlResponse, response.getContentAsString());
//	}
}
