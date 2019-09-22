package com.alecgavrilovich.procurement.domain;

public class Proizvod {
	
	private Integer Id;
	private String OpisPr;
	private String jmId;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getOpisPr() {
		return OpisPr;
	}
	public void setOpisPr(String opisPr) {
		OpisPr = opisPr;
	}
	public String getJmId() {
		return jmId;
	}
	public void setJmId(String jmId) {
		this.jmId = jmId;
	}
	
	
}
