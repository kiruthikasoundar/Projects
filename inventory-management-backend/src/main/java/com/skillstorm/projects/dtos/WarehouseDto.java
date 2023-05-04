package com.skillstorm.projects.dtos;

import java.util.Objects;

public class WarehouseDto {

	private long id;
	private String name;
	private int maxCapacity;
	
	public WarehouseDto() {
		super();
	}

	public WarehouseDto(long id, String name, int maxCapacity) {
		super();
		this.id = id;
		this.name = name;
		this.maxCapacity = maxCapacity;

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

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
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
		WarehouseDto other = (WarehouseDto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	  
}
