package com.inventory.MobileClient.model;

public class PurchaseBean {
	private Long id;
	private String itemName;
	private Integer quantity;
	private Double purchasePrice;
	private Integer status;
	
	public PurchaseBean(){
		
	}
	
	public PurchaseBean(String itemName, Integer quantity) {
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

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
