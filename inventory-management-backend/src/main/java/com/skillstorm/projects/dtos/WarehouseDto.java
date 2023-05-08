package com.skillstorm.projects.dtos;

import java.util.Objects;

public class WarehouseDto {

	private long id;
	private String name;
	private int maxCapacity;
	private int currentCapacity;
	
	public WarehouseDto() {
		super();
	}

	public WarehouseDto(long id, String name, int maxCapacity, int currentCapacity) {
		super();
		this.id = id;
		this.name = name;
		this.maxCapacity = maxCapacity;
		this.currentCapacity = currentCapacity;

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

	
	
	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
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
