package com.skillstorm.projects.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.skillstorm.projects.dtos.WarehouseDto;
import com.skillstorm.projects.models.Warehouse;

/**

Repository interface for managing warehouses in the database.

Provides methods for finding warehouses by name, and for CRUD operations.

Uses Spring Data JPA for implementing the repository methods.
*/
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

	/**

	Finds all warehouses with the given name.
	@Param name the name to search for
	@return a list of warehouses with the given name
	*/
	public List<Warehouse> findByName(String name);	
	
	
//	@Query("SELECT warehouse.id AS warehouse_id, warehouse.max_capacity, SUM(inventory.quantity) AS total_quantity FROM warehouse JOIN inventory ON warehouse.id = inventory.warehouse_id GROUP BY warehouse.id")
//	public WarehouseDto findWarehouseById(@PathVariable long id);
}
