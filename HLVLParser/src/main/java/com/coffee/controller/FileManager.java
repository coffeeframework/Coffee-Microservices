package com.coffee.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class FileManager {

	public final static String DEFAULT_NAME = "modelX";
	private String modelName;

	public File createFile(String content) throws IOException {

		File file = new File("./hlvl/" + DEFAULT_NAME + ".hlvl");
		FileOutputStream fop = new FileOutputStream(file);

		file.createNewFile();

		byte[] contentInBytes = content.getBytes();

		fop.write(contentInBytes);
		fop.flush();
		fop.close();
		return file;
	}
	public void getName(String model) {
		String aux = model.split("elements: ")[0];
		modelName = aux.substring(7,aux.length()-1);
		System.out.println("modelName: " + modelName);
	}

	public String fileReader() throws IOException {
		System.out.println( ">>>: fileReader [Creating JSON]");
		byte[] encoded = Files.readAllBytes(Paths.get(Controller.DIR + "/src-gen/"+modelName+".mzn"));
		String mzn = new String(encoded, "UTF-8");

		encoded = Files.readAllBytes(Paths.get(Controller.DIR + "/src-gen/"+modelName+"_Operations.json"));
		String json = new String(encoded, "UTF-8");
		
		HLVLParserWrapper wrapper  = new HLVLParserWrapper(mzn,json);
		Gson gson = new Gson();
		String example =  gson.toJson(wrapper);
		System.out.println(example);
		
		return example;
	}
}
