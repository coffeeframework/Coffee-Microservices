package com.coffee.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	@CrossOrigin
	@RequestMapping(value = "/coffeHLVLP/hlvlParser", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	//TODO do: complete the method
	public String hlvlParser(@RequestBody JSONObject data) throws Exception {
		System.out.println(data);
		return (String) data.get("data");
	}
}
