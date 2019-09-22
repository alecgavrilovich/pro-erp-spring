package com.alecgavrilovich.procurement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JM")
public class JM {
	
	@Id
	private String id;
	@Column(name="OPISJM")
	private String opisJm;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOpisJm() {
		return opisJm;
	}
	
	public void setOpisJm(String opisJm) {
		this.opisJm = opisJm;
	}
	
}
