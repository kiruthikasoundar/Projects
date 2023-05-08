package com.skillstorm.projects.dtos;

import java.util.Objects;

public class InventoryDto {

	private long id;
    private long productId;
    private long warehouseId;
    private int quantity;
    private String productName;
	
    public InventoryDto() {
		super();
	}

	public InventoryDto(long id, long productId, long warehouseId, int quantity, String productName) {
		super();
		this.id = id;
		this.productId = productId;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
		this.productName = productName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryDto other = (InventoryDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "InventoryDto [id=" + id + ", productId=" + productId + ", warehouseId=" + warehouseId + ", quantity="
				+ quantity + ", productName=" + productName + "]";
	}
    
	  
}
