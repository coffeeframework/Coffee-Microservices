package com.coffee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coffee.generator.HLVLParser;


@org.springframework.web.bind.annotation.RestController
public class Controller {

	public final static String DIR = System.getProperty("user.dir");
	private final static String HLVL_DIR = "/hlvl/";

	@Autowired
	FileManager fileCreator;

	@Autowired
	CmdExecutor executor;

	@CrossOrigin
	@RequestMapping(value = "/coffeeHLVLP/hlvlParser", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String hlvlParser(@RequestBody JSONObject data) throws Exception {
		System.out.println("1");
		String content = (String) data.get("data");
		return "";
		//return HLVLParser.runGenerator(content);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/coffeeHLVLP/hlvlParserFile", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String hlvlParserFile(@RequestBody JSONObject data) throws Exception {
		System.out.println( ">>>: hlvlParserFile"  );
		String content = (String) data.get("data");
		fileCreator.getName(content);
		fileCreator.createFile(content);
		executor.initialize(DIR);
		parseHLVL();
		return fileCreator.fileReader();
	}

	private void parseHLVL() throws InterruptedException, IOException {
		System.out.println( ">>>: parseHLVL"  );
		List<String> params = new ArrayList<String>();
		String command = "java -jar "+ "\"" + DIR + "/dependencies/HLVLParserV1.4.jar"+ "\" " + "\"" +DIR+ HLVL_DIR + FileManager.DEFAULT_NAME+ ".hlvl"+ "\"";
		System.out.println(command);
		params.add(command);
		executor.setCommandInConsole(params);
		executor.runCmd();
		System.out.println(executor.getDebugLog());
	}

}
