package com.alecgavrilovich.procurement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(StavkaZZPId.class)
public class StavkaZZP {
	
	@Id
	@Column(name="SIFRAZZP")
	private Integer sifraZZP;
	@Id
	@Column(name="REDNIBR")
	private Integer redniBr;
	@Column(name="STATUS")
	private int status;
	@Column(name="SIFRAPR")
	private Integer sifraPr;
	@Column(name="OPISPR")
	private String opisPr;
	@Column(name="KOLICINA")
	private Integer kolicina;
	@Column(name="CENA")
	private Integer cena;
	@Column(name="CENAZAKOM")
	private Integer cenaZaKom;
	@Column(name="VREDNOST")
	private Integer vrednost;
	@Column(name="VALUTAID")
	private Integer valutaId;
	@Column(name="VALUTAOPIS")
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
	public Integer getValutaId() {
		return valutaId;
	}
	public void setValutaId(Integer valutaId) {
		this.valutaId = valutaId;
	}
	public String getValutaOpis() {
		return valutaOpis;
	}
	public void setValutaOpis(String valutaOpis) {
		this.valutaOpis = valutaOpis;
	}
	
}
