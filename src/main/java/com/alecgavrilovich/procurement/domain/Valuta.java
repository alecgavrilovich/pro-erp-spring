package com.alecgavrilovich.procurement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VALUTA")
public class Valuta {
	
	@Id
	private String id;
	@Column(name="OPISVAL")
	private String opisVal;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOpisVal() {
		return opisVal;
	}
	public void setOpisVal(String opisVal) {
		this.opisVal = opisVal;
	}

}
