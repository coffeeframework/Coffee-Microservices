package com.coffee.controller;

import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@CrossOrigin
	@RequestMapping(value = "/reasoning/validModel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean validModel(@RequestBody JSONObject data) throws Exception {

		boolean isValid = true; 
		System.out.println(data.get("data"));
		return isValid;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/reasoning/oneConfiguration", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String oneConfiguration(@RequestBody JSONObject model, @RequestBody JSONObject configuration) throws Exception {

		System.out.println("Model: " + model.get("data"));
		System.out.println("Configuration: " + configuration.get("data"));
		
		String solution = "One configuration";
		return solution;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/reasoning/nConfigurations", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String nConfigurations(@RequestBody int n, @RequestBody JSONObject configuration) throws Exception {

		System.out.println("Number of configurations: " + n);
		System.out.println("Configuration: " + configuration.get("data"));
		
		String solution = "N configuration";
		return solution;
	}
	
}
