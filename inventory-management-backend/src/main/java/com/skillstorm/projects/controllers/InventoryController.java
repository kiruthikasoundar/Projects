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
import org.springframework.web.bind.annotation.RestController;
import com.skillstorm.projects.dtos.InventoryDto;
import com.skillstorm.projects.services.InventoryService;

@RestController
@RequestMapping
@CrossOrigin
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	

	/**
	 * Returns all inventory items associated with the warehouse matching the given id.
	 * @Param id The id of the warehouse to search for inventory.
	 * @return A List of InventoryDto objects representing the matching inventory items.
	 */
	@GetMapping("warehouses/{id}/inventory")
	public List<InventoryDto>findAllInventoryByWarehouseId(@PathVariable long id) {
		return inventoryService.findAllInventoryByWarehouseId(id);
	}
	
	/**
	 * Returns all inventory items.
	 * @return A List of InventoryDto objects representing all inventory items.
	 */
	@GetMapping("/inventory")
	public List<InventoryDto>findAllInventory(){
		return inventoryService.findAllInventory();
	}
	
	/**
	 * Creates an inventory item associated with the warehouse matching the given id.
	 * @Param id The id of the warehouse to associate the new inventory item with.
	 * @Param inventoryData The InventoryDto object representing the new inventory item to be created.
	 * @return The InventoryDto object representing the newly created inventory item.
	 */
	@PostMapping("warehouses/{id}/inventory")
	public InventoryDto createInventoryByWarehouseId(@PathVariable long id, @RequestBody InventoryDto inventoryData) {
		inventoryData.setId(id);
		return inventoryService.createInventoryByWarehouseId(inventoryData);
	}
	
	/**
	 * Creates a new inventory item.
	 * @Param inventoryData The InventoryDto object representing the new inventory item to be created.
	 * @return A ResponseEntity containing the InventoryDto object representing the newly created inventory item and a CREATED HTTP status code.
	 */
	@PostMapping("/inventory")
	public ResponseEntity<InventoryDto>createInventory(@RequestBody InventoryDto inventoryData){
		InventoryDto Inventory = inventoryService.createInventory(inventoryData);
		return new ResponseEntity<>(Inventory, HttpStatus.CREATED);
	}
	
	/**
	 * Updates an existing inventory item matching the given id.
	 * @Param id The id of the inventory item to be updated.
	 * @Param inventoryData The InventoryDto object representing the updated inventory item data.
	 * @return The InventoryDto object representing the updated inventory item.
	 */
	@PutMapping("/inventory/{id}")
	public InventoryDto updateInventory(@PathVariable long id, @RequestBody InventoryDto inventoryData) {
		inventoryData.setId(id);
		return  inventoryService.updateInventory(inventoryData);
	}
	
	/**
	 * Deletes an existing inventory item matching the given id.
	 * @Param id The id of the inventory item to be deleted.
	 */
	@DeleteMapping("/inventory/{id}")
	public void deleteInventory(@PathVariable long id) {
		inventoryService.deleteInventory(id);
	}
	

}
