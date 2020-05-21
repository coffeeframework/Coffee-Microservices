package com.coffee.controller;

public class HLVLParserWrapper {
	
	
	private String mzn;
	private String json;
	
	public HLVLParserWrapper(String mzn, String json) {
		this.mzn = mzn;
		this.json = json;
	}
	
	public HLVLParserWrapper() {
		
	}
	
	public String getMzn() {
		return mzn;
	}
	public void setMzn(String mzn) {
		this.mzn = mzn;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	
	

}
