package com.alecgavrilovich.procurement.commands;

import java.sql.Date;

public class OFSItemForm {

	private Integer id;
	private Integer ofsId;
	private String productName;
	private Integer productId;
	private Integer quantity;
	private Date orderDate;
	private Date deliveryTime;
	private int status = 0;
	
	public Integer getOfsId() {
		return ofsId;
	}
	public void setOfsId(Integer ofsId) {
		this.ofsId = ofsId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
