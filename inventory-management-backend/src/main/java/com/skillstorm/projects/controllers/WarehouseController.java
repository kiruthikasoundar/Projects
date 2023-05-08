package com.skillstorm.projects.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.projects.dtos.WarehouseDto;
import com.skillstorm.projects.services.WarehouseServices;


@RestController
@RequestMapping("/warehouses")
@CrossOrigin
public class WarehouseController {

	 /**
     * Service for handling warehouse operations.
     */
	@Autowired
	private WarehouseServices warehouseService;
	
	 /**
     * Retrieves all warehouses from the database.
     * @Param name Optional query parameter used to filter results by warehouse name.
     * @return A list of all warehouses matching the specified criteria.
     */
	@GetMapping
	public List<WarehouseDto> findallWarehouses(@RequestParam(required = false) String name) {
		return warehouseService.findAllWarehouses(name);
	}
	
	 /**
     * Retrieves a single warehouse by its ID.
     * @Param id The ID of the warehouse to retrieve.
     * @return The warehouse with the specified ID.
     */
	@GetMapping("/{id}")
	public WarehouseDto findWarehouseById(@PathVariable long id) {
		return warehouseService.findWarehouseById(id);
	}
	
	 /**
     * Creates a new warehouse in the database.
     * @Param warehouseData The data for the warehouse to create.
     * @return The newly created warehouse.
     */
	@PostMapping
	public ResponseEntity<WarehouseDto> createWarehouse(@RequestBody WarehouseDto warehouseData) {
		WarehouseDto Warehouse =  warehouseService.createWarehouse(warehouseData);
			return new ResponseEntity <>(Warehouse, HttpStatus.CREATED);
	}
	
	/**
     * Updates an existing warehouse in the database.
     * @Param id The ID of the warehouse to update.
     * @Param warehouseData The updated data for the warehouse.
     * @return The updated warehouse.
     */
	@PutMapping("/{id}")
	public WarehouseDto updateWarehouse(@PathVariable long id, @RequestBody WarehouseDto warehouseData) {
		warehouseData.setId(id);
		return  warehouseService.updateWarehouse(warehouseData);
	}
	
	/**
     * Deletes a warehouse from the database.
     * @Param id The ID of the warehouse to delete.
     */
	@DeleteMapping("/{id}")
	public void deleteWarehouse(@PathVariable long id) {
		warehouseService.deleteWarehouse(id);
	}
}
