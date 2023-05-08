package com.skillstorm.projects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.projects.dtos.InventoryDto;
import com.skillstorm.projects.models.Inventory;
import com.skillstorm.projects.models.Product;
import com.skillstorm.projects.models.Warehouse;
import com.skillstorm.projects.repositories.InventoryRepository;
import com.skillstorm.projects.repositories.ProductRepository;
import com.skillstorm.projects.repositories.WarehouseRepository;

@Service
@Transactional
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Find all inventories by warehouse id
	 * @Param id warehouse id to search by
	 * @return List of inventory dtos
	 */
	public List<InventoryDto>findAllInventoryByWarehouseId(long id){
		return inventoryRepository.findAllInventoryByWarehouseId(id)
				.stream()	
				.map(w -> w.toDto())
				.toList();
	}

	/**
	 * Create an inventory for a specific warehouse id
	 * @Param inventoryData Inventory dto containing product id, warehouse id, and quantity
	 * @return Inventory dto representing created inventory
	 */
	public InventoryDto createInventoryByWarehouseId(InventoryDto inventoryData) {
		Warehouse warehouse = warehouseRepository.findById(inventoryData.getWarehouseId())
				.orElseThrow();
		Product product = productRepository.findById(inventoryData.getProductId())
				.orElseThrow();
		Inventory inventory = new Inventory(inventoryData.getId(),product,warehouse,inventoryData.getQuantity());
		return inventoryRepository.save(inventory).toDto();
	}

	/**
	 * Find all inventories
	 * @return List of inventory dtos
	 */
	public List<InventoryDto> findAllInventory() {
		return inventoryRepository.findAll()
				.stream()	
				.map(w -> w.toDto())
				.toList();
	}

	/**
	 * Create an inventory
	 * @Param inventoryData Inventory dto containing product id, warehouse id, and quantity
	 * @return Inventory dto representing created inventory
	 */
	public InventoryDto createInventory(InventoryDto inventoryData) {
		Warehouse warehouse = warehouseRepository.findById(inventoryData.getWarehouseId())
				.orElseThrow();
		Product product = productRepository.findById(inventoryData.getProductId())
				.orElseThrow();
		Inventory inventory = new Inventory(inventoryData.getId(),product,warehouse,inventoryData.getQuantity());
		return inventoryRepository.save(inventory).toDto();
	}
	
	/**
	 * Update an existing inventory
	 * @Param inventoryData Inventory dto containing product id, warehouse id, and quantity
	 * @return Inventory dto representing updated inventory
	 */
	public InventoryDto updateInventory(InventoryDto inventoryData) {
		Warehouse warehouse = warehouseRepository.findById(inventoryData.getWarehouseId())
				.orElseThrow();
		Product product = productRepository.findById(inventoryData.getProductId())
				.orElseThrow();
		Inventory inventory = new Inventory(inventoryData.getId(),product,warehouse,inventoryData.getQuantity());
		return inventoryRepository.save(inventory).toDto();
	}
	
	/**
	 * Delete an existing inventory
	 * @Param id Inventory id to delete
	 */
	public void deleteInventory(long id) {
		inventoryRepository.deleteById(id);
	}

	/**
	 * Find all inventories by warehouse id
	 * @Param warehouseId Warehouse id to search by
	 * @return List of inventories
	 */
	public List<Inventory> findByWarehouseId(Long warehouseId) {
		return inventoryRepository.findAll();
	}
}
