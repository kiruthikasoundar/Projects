package com.skillstorm.projects.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.projects.dtos.InventoryDto;
import com.skillstorm.projects.models.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	/**
	 * Retrieves a list of Inventory entities associated with the warehouse with the specified ID.
	 * 
	 * @Param id the ID of the warehouse
	 * @return a list of Inventory entities associated with the warehouse with the specified ID
	 */
	@Query("select i from Inventory i where i.warehouse.id = ?1 ")
	public List<Inventory>findAllInventoryByWarehouseId(long id);
	
}
