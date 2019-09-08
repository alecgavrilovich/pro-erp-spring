package com.alecgavrilovich.procurement.domain;

public class Valuta {
	
	private Integer id;
	private String opisVal;
	
	public Integer vratiId() {
		return id;
	}
	public void postaviId(Integer id) {
		this.id = id;
	}
	public String vratiOpisVal() {
		return opisVal;
	}
	public void postaviOpisVal(String opisVal) {
		this.opisVal = opisVal;
	}

}
