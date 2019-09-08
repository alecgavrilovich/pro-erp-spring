package com.alecgavrilovich.procurement.domain;

public class Dobavljac {
	
	private Integer sifraDob;
	private String opisDob;
	
	public Integer vratiSifraDob() {
		return sifraDob;
	}
	public void postaviSifraDob(Integer sifraDob) {
		this.sifraDob = sifraDob;
	}
	public String vratiOpisDob() {
		return opisDob;
	}
	public void postaviOpisDob(String opisDob) {
		this.opisDob = opisDob;
	}

}
