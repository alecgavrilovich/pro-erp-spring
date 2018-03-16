package com.alecgavrilovich.procurement.commands;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.alecgavrilovich.procurement.domain.OFSItem;

public class OFSForm {

	private Integer id;
	private Date orderDate;
	private Integer employeeId;
	
	private List<OFSItem> ofsItems = new ArrayList<>();
	
	public List<OFSItem> getOfsItems() {
		return ofsItems;
	}
	
	public void setOfsItems(List<OFSItem> ofsItems) {
		this.ofsItems = ofsItems;
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
