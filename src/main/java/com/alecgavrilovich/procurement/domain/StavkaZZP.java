package com.alecgavrilovich.procurement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StavkaZZP {
	
	@Id
	private Integer sifraZZP;
	private Integer redniBr;
	private int status;
	private Integer sifraPr;
	private String opisPr;
	private Integer kolicina;
	private Integer cena;
	private Integer cenaZaKom;
	private Integer vrednost;
	private Integer valuraId;
	private String valutaOpis;
	
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Integer getSifraPr() {
		return sifraPr;
	}
	public void setSifraPr(Integer sifraPr) {
		this.sifraPr = sifraPr;
	}
	public String getOpisPr() {
		return opisPr;
	}
	public void setOpisPr(String opisPr) {
		this.opisPr = opisPr;
	}
	public Integer getKolicina() {
		return kolicina;
	}
	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}
	public Integer getCena() {
		return cena;
	}
	public void setCena(Integer cena) {
		this.cena = cena;
	}
	public Integer getCenaZaKom() {
		return cenaZaKom;
	}
	public void setCenaZaKom(Integer cenaZaKom) {
		this.cenaZaKom = cenaZaKom;
	}
	public Integer getVrednost() {
		return vrednost;
	}
	public void setVrednost(Integer vrednost) {
		this.vrednost = vrednost;
	}
	public Integer getValuraId() {
		return valuraId;
	}
	public void setValuraId(Integer valuraId) {
		this.valuraId = valuraId;
	}
	public String getValutaOpis() {
		return valutaOpis;
	}
	public void setValutaOpis(String valutaOpis) {
		this.valutaOpis = valutaOpis;
	}
	
}
