package com.inventory.MobileClient.model;

public class SaleBean {
	private Long id;
	private String itemName;
	private Integer quantity;
	private Double costPrice;
	private Double sellingPrice;
	private Integer status;
	
	public SaleBean(){
		
	}	
	
	public SaleBean(String itemName, Integer quantity) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
