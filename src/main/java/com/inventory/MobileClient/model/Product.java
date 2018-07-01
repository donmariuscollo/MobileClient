package com.inventory.MobileClient.model;

public class Product {
	private Long id;
	private String itemName;
	private Double costPrice;
	private Double sellingPrice;
	private Integer quantity;
	
	public Product(){
		
	}
	
	public Product(String itemName, Double costPrice, Double sellingPrice){
		this(itemName,costPrice,sellingPrice,0);
	}
	
	public Product(String itemName, Double costPrice, Double sellingPrice, Integer quantity) {
		super();
		this.itemName = itemName;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
