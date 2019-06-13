package com.coffee.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.modelParsers.featureIDEToHlvlParser.FeatureIDEToHLVL;
import com.coffee.modelParsers.varXmlToHLVLParser.VariamosXMLToHlvlParser;

@RestController
public class Controller {

	@CrossOrigin
	@RequestMapping(value = "/feature2Hlvl", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	//FIXME corregir el parser de featureIDE
	public String executeTest(@RequestBody JSONObject data) throws Exception {

		System.out.println(data.get("data"));
			FeatureIDEToHLVL fParser = new FeatureIDEToHLVL();
		
		return fParser.parse((String) data.get("data"));
	}

	@CrossOrigin
	@RequestMapping(value = "/varXML2Hlvl", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String varXML2Hlvl(@RequestBody JSONObject data) throws Exception {
		System.out.println("Hola");
		System.out.println(data.get("data"));
		
		VariamosXMLToHlvlParser vParser = new VariamosXMLToHlvlParser();
	
	return vParser.parse((String) data.get("data"));
	}

	@CrossOrigin
	@RequestMapping(value = "/splot2Hlvl", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String splot2Hlvl(@RequestBody String data) {

		return "";
	}
}
	
//	@CrossOrigin
//	@RequestMapping(value = "/parseHlvl", method = RequestMethod.POST, produces = "application/json")
//	@ResponseBody
//	public String parse(@RequestBody String data) {
//
//		return "";
//	}