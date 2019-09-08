package com.alecgavrilovich.procurement.domain;

public class StavkaZZP {
	
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
	
	public Integer vratiSifraZZP() {
		return sifraZZP;
	}
	public void postaviSifraZZP(Integer sifraZZP) {
		this.sifraZZP = sifraZZP;
	}
	public Integer vratiRedniBr() {
		return redniBr;
	}
	public void postaviRedniBr(Integer redniBr) {
		this.redniBr = redniBr;
	}
	public int vratiStatus() {
		return status;
	}
	public void postaviStatus(int status) {
		this.status = status;
	}
	public Integer vratiSifraPr() {
		return sifraPr;
	}
	public void postaviSifraPr(Integer sifraPr) {
		this.sifraPr = sifraPr;
	}
	public String vratiOpisPr() {
		return opisPr;
	}
	public void postaviOpisPr(String opisPr) {
		this.opisPr = opisPr;
	}
	public Integer vratiKolicina() {
		return kolicina;
	}
	public void postaviKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}
	public Integer vratiCena() {
		return cena;
	}
	public void postaviCena(Integer cena) {
		this.cena = cena;
	}
	public Integer vratiCenaZaKom() {
		return cenaZaKom;
	}
	public void postaviCenaZaKom(Integer cenaZaKom) {
		this.cenaZaKom = cenaZaKom;
	}
	public Integer vratiVrednost() {
		return vrednost;
	}
	public void postaviVrednost(Integer vrednost) {
		this.vrednost = vrednost;
	}
	public Integer vratiValuraId() {
		return valuraId;
	}
	public void postaviValuraId(Integer valuraId) {
		this.valuraId = valuraId;
	}
	public String vratiValutaOpis() {
		return valutaOpis;
	}
	public void postaviValutaOpis(String valutaOpis) {
		this.valutaOpis = valutaOpis;
	}
	
}
