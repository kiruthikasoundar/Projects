package com.skillstorm.projects.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.projects.dtos.InventoryDto;
import com.skillstorm.projects.services.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/warehouses/{id}/inventory")
	public List<InventoryDto>findAllInventoryByWarehouseId(@PathVariable long id) {
		return inventoryService.findAllInventoryByWarehouseId(id);
	}
	
	@PostMapping("/warehouses/{id}/inventory")
	public InventoryDto createInventoryByWarehouseId(@PathVariable long id, @RequestBody InventoryDto inventoryData) {
		inventoryData.setId(id);
		return inventoryService.createInventory(inventoryData);
	}
}
