package com.alecgavrilovich.procurement.commands;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OFSForm {

	private Integer id;
	private Date orderDate;
	private Integer employeeId;
	private List<OFSItemForm> ofsItemsForms = new ArrayList<>();
	

	public List<OFSItemForm> getOfsItemsForms() {
		return ofsItemsForms;
	}
	
	public void setOfsItemsForms(List<OFSItemForm> ofsItemsForms) {
		this.ofsItemsForms = ofsItemsForms;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
