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
	
	public List<InventoryDto>findAllInventoryByWarehouseId(long id){
		return inventoryRepository.findAllInventoryByWarehouseId(id)
				.stream()
				.map(i -> i.toDto())
				.toList();
	}

	public InventoryDto createInventory(InventoryDto inventoryData) {
		Warehouse warehouse = warehouseRepository.findById(inventoryData.getWarehouseId())
				.orElseThrow();
		Product product = productRepository.findById(inventoryData.getProductId())
				.orElseThrow();
		Inventory inventory = new Inventory(inventoryData.getId(),product,warehouse,inventoryData.getQuantity());
		return inventoryRepository.save(inventory).toDto();
	}
}
