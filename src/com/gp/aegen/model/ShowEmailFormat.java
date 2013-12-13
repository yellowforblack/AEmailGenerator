package com.gp.aegen.model;

public class ShowEmailFormat {

	String firstFld = null;
	String secondFld = null;
	String keyword = null;
	String midiator = null;
	String frontKwrd = null;
	String backKwrd = null;
	String domain = null;
	
	public ShowEmailFormat(){	
	}

	public String getFirstFld() {
		return firstFld;
	}

	public void setFirstFld(String firstFld) {
		this.firstFld = firstFld;
	}

	public String getSecondFld() {
		return secondFld;
	}

	public void setSecondFld(String secondFld) {
		this.secondFld = secondFld;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getMidiator() {
		return midiator;
	}

	public void setMidiator(String midiator) {
		this.midiator = midiator;
	}

	public String getFrontKwrd() {
		return frontKwrd;
	}

	public void setFrontKwrd(String frontKwrd) {
		this.frontKwrd = frontKwrd;
	}

	public String getBackKwrd() {
		return backKwrd;
	}

	public void setBackKwrd(String backKwrd) {
		this.backKwrd = backKwrd;
	}
	
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getEmailFormat(){
		
		String emailFormat;
		
		emailFormat = getFrontKwrd()+""+getFirstFld()+""+getMidiator()+""+getSecondFld()+""+getBackKwrd()+""+getDomain();
		
		return emailFormat.trim();
	}
	
	
}
