package com.alecgavrilovich.procurement.domain;

import java.sql.Date;
import java.util.List;

public class ZZP {
	
	private Integer sifraZZP;
	private Date datum;
	private Integer sifraDob;
	private String imeDob;
	private Integer vrednostZZP;
	private List<StavkaZZP> stavke;
	
	public Integer vratiSifraZZP() {
		return sifraZZP;
	}
	public void postaviSifraZZP(Integer sifraZZP) {
		this.sifraZZP = sifraZZP;
	}
	public Date vratiDatum() {
		return datum;
	}
	public void postaviDatum(Date datum) {
		this.datum = datum;
	}
	public Integer vratiSifraDob() {
		return sifraDob;
	}
	public void postaviSifraDob(Integer sifraDob) {
		this.sifraDob = sifraDob;
	}
	public String vratiImeDob() {
		return imeDob;
	}
	public void postaviImeDob(String imeDob) {
		this.imeDob = imeDob;
	}
	public Integer vratiVrednostZZP() {
		return vrednostZZP;
	}
	public void postaviVrednostZZP(Integer vrednostZZP) {
		this.vrednostZZP = vrednostZZP;
	}
	public List<StavkaZZP> vratiStavke() {
		return stavke;
	}
	public void postaviStavke(List<StavkaZZP> stavke) {
		this.stavke = stavke;
	}
	
}
