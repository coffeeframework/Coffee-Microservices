package com.coffee.reasoning.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.coffee.generator.HlvlGenerator;


@RestController
public class Controller {


	
	@CrossOrigin
	@RequestMapping(value = "/feature2Hlvl", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	//FIXME corregir el parser de featureIDE
	public String executeTest(@RequestBody JSONObject data) throws Exception {
		HlvlGenerator gen= new HlvlGenerator();
		gen.toBoolean(model, modelName, fsa)

	System.out.println(data.get("data"));
	

	return  data.get("data").toString();
	}
}
