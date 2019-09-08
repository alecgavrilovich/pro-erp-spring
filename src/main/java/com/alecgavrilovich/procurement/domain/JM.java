package com.alecgavrilovich.procurement.domain;

public class JM {
	
	private Integer id;
	private String opisJm;
	
	public Integer vratiId() {
		return id;
	}
	
	public void postaviId(Integer id) {
		this.id = id;
	}
	
	public String vratiOpisJm() {
		return opisJm;
	}
	
	public void postaviOpisJm(String opisJm) {
		this.opisJm = opisJm;
	}
	
}
