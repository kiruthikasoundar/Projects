package com.skillstorm.projects.dtos;

import java.util.Objects;

import com.skillstorm.projects.models.Category;

public class ProductDto {

	private long id;
	private String name;
	private long price;
	private long categoryId;
	
	
	public ProductDto() {
		super();
	}
	
	public ProductDto(long id, String name, long price, long categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	
	public void setCategory(long categoryId) {
		this.categoryId = categoryId;
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
		ProductDto other = (ProductDto) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", categoryId=" + categoryId + "]";
	}
	
	
}
