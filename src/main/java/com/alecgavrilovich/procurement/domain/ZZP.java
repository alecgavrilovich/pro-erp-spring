package com.alecgavrilovich.procurement.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ZZP")
public class ZZP {
	
	@Id
	private Integer sifraZZP;
	@Column(name="DATUM")
	private Date datum;
	@Column(name="SIFRADOB")
	private Integer sifraDob;
	@Column(name="IMEDOB")
	private String imeDob;
	@Column(name="VREDNOSTZZP")
	private Integer vrednostZZP;
	@Transient
	private List<StavkaZZP> stavke;
	
	public Integer getSifraZZP() {
		return sifraZZP;
	}
	public void setSifraZZP(Integer sifraZZP) {
		this.sifraZZP = sifraZZP;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Integer getSifraDob() {
		return sifraDob;
	}
	public void setSifraDob(Integer sifraDob) {
		this.sifraDob = sifraDob;
	}
	public String getImeDob() {
		return imeDob;
	}
	public void setImeDob(String imeDob) {
		this.imeDob = imeDob;
	}
	public Integer getVrednostZZP() {
		return vrednostZZP;
	}
	public void setVrednostZZP(Integer vrednostZZP) {
		this.vrednostZZP = vrednostZZP;
	}
	public List<StavkaZZP> getStavke() {
		return stavke;
	}
	public void setStavke(List<StavkaZZP> stavke) {
		this.stavke = stavke;
	}
	
}
