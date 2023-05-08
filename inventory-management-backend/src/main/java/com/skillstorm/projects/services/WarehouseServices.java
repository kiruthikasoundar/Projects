package com.skillstorm.projects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.projects.dtos.WarehouseDto;
import com.skillstorm.projects.models.Warehouse;
import com.skillstorm.projects.repositories.WarehouseRepository;

@Service
@Transactional
public class WarehouseServices {

	@Autowired
	private WarehouseRepository warehouseRepository;
	
	/**

	Retrieves all the warehouses from the database or the warehouses with matching name
	@Param name the name to search for. If null, return all warehouses.
	@return List of WarehouseDto objects representing the retrieved warehouses.
	*/
	public List<WarehouseDto> findAllWarehouses(String name) {
		
		if (name == null) {
				return warehouseRepository.findAll()
					.stream()
					.map(w -> w.toDto())
					.toList();
		}
		return warehouseRepository.findByName(name)
				.stream()
				.map(w -> w.toDto())
				.toList();
	}
	
	/**

	Retrieves a warehouse by its ID from the database.
	@Param id the ID of the warehouse to retrieve.
	@return a WarehouseDto object representing the retrieved warehouse.
	@throws NoSuchElementException if the warehouse with the specified ID does not exist in the database.
	*/
	public WarehouseDto findWarehouseById(long id) {
		return warehouseRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	/**

	Creates a new warehouse in the database.
	@Param warehouseData a WarehouseDto object representing the data for the warehouse to create.
	@return a WarehouseDto object representing the created warehouse.
	*/
	public WarehouseDto createWarehouse(WarehouseDto warehouseData) {
		Warehouse warehouse = new Warehouse(warehouseData.getId(),warehouseData.getName(),warehouseData.getMaxCapacity(), warehouseData.getCurrentCapacity());
		return warehouseRepository.save(warehouse).toDto();
	}

	/**

	Updates an existing warehouse in the database.
	@Param warehouseData a WarehouseDto object representing the data for the warehouse to update.
	@return a WarehouseDto object representing the updated warehouse.
	*/
	public WarehouseDto updateWarehouse(WarehouseDto warehouseData) {		
		Warehouse warehouse = new Warehouse(warehouseData.getId(),warehouseData.getName(),warehouseData.getMaxCapacity(),warehouseData.getCurrentCapacity());
		return warehouseRepository.save(warehouse).toDto();
	}

	/**

	Deletes an existing warehouse from the database.
	@Param id the ID of the warehouse to delete.
	*/
	public void deleteWarehouse(long id) {
		warehouseRepository.deleteById(id);
	}
}
