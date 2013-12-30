package com.gp.aegen.model;

import com.gp.aegen.impl.InputDataRequired;

public class Data implements InputDataRequired{
	String firstField;
	String secondField;
	String midiator;
	String domainName;
	String frontKwrd;
	String backKwrd;
	
	public void setFirstField(String firstField) {
		this.firstField = firstField;
	}

	public void setSecondField(String secondField) {
		this.secondField = secondField;
	}

	public void setMidiator(String midiator) {
		this.midiator = midiator;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public void setFrontKwrd(String frontKwrd) {
		this.frontKwrd = frontKwrd;
	}

	public void setBackKwrd(String backKwrd) {
		this.backKwrd = backKwrd;
	}

	@Override
	public String getFirstField() {
		return firstField;
	}

	@Override
	public String getSecondField() {
		return secondField;
	}

	@Override
	public String getMidiator() {
		return midiator;
	}

	@Override
	public String getDomainName() {
		return domainName;
	}

	@Override
	public String getFrontKwrd() {
		return frontKwrd;
	}

	@Override
	public String getBackKwrd() {
		return backKwrd;
	}

}
