package com.alecgavrilovich.procurement.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RNote {
	
	@Id
	private Integer id;
	private Date dateReceived;
	private Integer employeeId;
	private Integer supplierId;
	private Integer dnoteId;
	private Integer dnoteItemId;
	private String status;
	private Integer inspector;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public Integer getDnoteId() {
		return dnoteId;
	}
	public void setDnoteId(Integer dnoteId) {
		this.dnoteId = dnoteId;
	}
	public Integer getDnoteItemId() {
		return dnoteItemId;
	}
	public void setDnoteItemId(Integer dnoteItemId) {
		this.dnoteItemId = dnoteItemId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getInspector() {
		return inspector;
	}
	public void setInspector(Integer inspector) {
		this.inspector = inspector;
	}
	
	
}
