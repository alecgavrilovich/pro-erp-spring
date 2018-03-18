package com.alecgavrilovich.procurement.domain;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OFS {
	
	@Id
	private Integer id;
	
	private Date orderDate;
	
	private Integer employeeId;

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
