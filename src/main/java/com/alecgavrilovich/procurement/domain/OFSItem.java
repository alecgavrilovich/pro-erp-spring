package com.alecgavrilovich.procurement.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OFS_ITEM")
public class OFSItem {
	
	@Id
	private Integer id;
	@Column(name="OFS_ID")
	private Integer ofsId;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="PRODUCT_ID")
	private Integer productId;
	private Integer quantity;
	@Column(name="ORDER_DATE")
	private Date orderDate;
	@Column(name="DELIVERY_TIME")
	private Date deliveryTime;
	
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
	
	
}
