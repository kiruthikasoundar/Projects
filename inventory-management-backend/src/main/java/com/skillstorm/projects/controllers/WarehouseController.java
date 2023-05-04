package com.skillstorm.projects.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class WarehouseController {

	@Autowired
	private WarehouseServices warehouseService;
	
	@GetMapping
	public List<WarehouseDto> findallWarehouses(@RequestParam(required = false) String name) {
		return warehouseService.findAllWarehouses(name);
	}
	
	@GetMapping("/{id}")
	public WarehouseDto findWarehouseById(@PathVariable long id) {
		return warehouseService.findWarehouseById(id);
	}
	
	@PostMapping("/warehouses")
	public ResponseEntity<WarehouseDto> createWarehouseDto(@RequestBody WarehouseDto warehouseData) {
		WarehouseDto Warehouse =  warehouseService.createWarehouse(warehouseData);
				return new ResponseEntity <>(Warehouse, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public WarehouseDto updateWarehouse(@PathVariable long id, @RequestBody WarehouseDto warehouseData) {
		warehouseData.setId(id);
		return  warehouseService.updateWarehouse(warehouseData);
	}
	
	@DeleteMapping("/{id}")
	public void deleteWarehouse(@PathVariable long id) {
		warehouseService.deleteWarehouse(id);
	}
}
