package com.alecgavrilovich.procurement.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StavkaZZPId implements Serializable {
	
	private Integer sifraZZP;
	private Integer redniBr;
	
	public Integer getSifraZZP() {
		return sifraZZP;
	}
	public void setSifraZZP(Integer sifraZZP) {
		this.sifraZZP = sifraZZP;
	}
	public Integer getRedniBr() {
		return redniBr;
	}
	public void setRedniBr(Integer redniBr) {
		this.redniBr = redniBr;
	}
	

}
