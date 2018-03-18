package com.alecgavrilovich.procurement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id
	private Integer id;
	private String name;
	private String address;
	private int telephone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	
}
