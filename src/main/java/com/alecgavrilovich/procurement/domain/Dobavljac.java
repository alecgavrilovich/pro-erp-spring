package com.alecgavrilovich.procurement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOBAVLJAC")
public class Dobavljac {
	
	@Id
	@Column(name="SIFRADOB")
	private Integer sifraDob;
	@Column(name="IMEDOB")
	private String imeDob;
	
	public Integer getSifraDob() {
		return sifraDob;
	}
	public void setSifraDob(Integer sifraDob) {
		this.sifraDob = sifraDob;
	}
	public String getOpisDob() {
		return imeDob;
	}
	public void setOpisDob(String opisDob) {
		this.imeDob = opisDob;
	}

}
