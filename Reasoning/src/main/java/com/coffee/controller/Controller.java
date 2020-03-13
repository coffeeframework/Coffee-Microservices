package com.coffee.controller;

import javax.json.JsonObject;

import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.com.coffee.reasoning.Reasoning;

@RestController
public class Controller {

	public final static String FRONTEND_DATA = "{\r\n" + " \"solverSelected\" : \"\",\r\n" + "\"configuration\" : \r\n"
			+ "{\r\n" + "}\r\n" + "}";

	@CrossOrigin
	@RequestMapping(value = "/reasoning/validModel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean validModel(@RequestBody JSONObject data) throws Exception {
		boolean isValid = true;
		return isValid;
	}

	@CrossOrigin
	@RequestMapping(value = "/reasoning/oneConfiguration", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String oneConfiguration(@RequestBody JSONObject model) throws Exception {
		String data = (String) model.get("data");
		String mnz = data.split("separadorcoffee")[0];
		String modelData = data.split("separadorcoffee")[1];
		Reasoning reasoning = new Reasoning();
		JsonObject solution = reasoning.coffeeCompile(mnz, FRONTEND_DATA, modelData, 1);
		return solution.get("solutions") + "";
	}

	@CrossOrigin
	@RequestMapping(value = "/reasoning/nConfigurations", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String nConfigurations(@RequestBody int n, @RequestBody JSONObject configuration,
			@RequestBody JSONObject model) throws Exception {
		Reasoning reasoning = new Reasoning();
		JsonObject solution = reasoning.coffeeCompile((String) model.get("data"), "",
				(String) configuration.get("data"), n);
		return solution.toString();
	}

}
