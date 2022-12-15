package com.OMS.dto;

import com.OMS.entity.Customer;

public class OrdersDto {

	
	private Integer totalPrice;
	private String description;
	private String productName;
	private Integer productPrice;
	private Integer quantity;
	private Customer customer;
	public OrdersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdersDto(Integer totalPrice, String description, String productName, Integer productPrice, Integer quantity,
			Customer customer) {
		super();
		this.totalPrice = totalPrice;
		this.description = description;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.customer = customer;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "OrdersDto [totalPrice=" + totalPrice + ", description=" + description + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", quantity=" + quantity + ", customer=" + customer + "]";
	}
	
	
}
