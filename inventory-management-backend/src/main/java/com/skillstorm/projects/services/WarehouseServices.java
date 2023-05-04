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
	
	public WarehouseDto findWarehouseById(long id) {
		return warehouseRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	public WarehouseDto createWarehouse(WarehouseDto warehouseData) {
		Warehouse warehouse = new Warehouse(warehouseData.getId(),warehouseData.getName(),warehouseData.getMaxCapacity());
		return warehouseRepository.save(warehouse).toDto();
	}

	public WarehouseDto updateWarehouse(WarehouseDto warehouseData) {
		Warehouse warehouse = new Warehouse(warehouseData.getId(),warehouseData.getName(),warehouseData.getMaxCapacity());
		return warehouseRepository.save(warehouse).toDto();
	}

	public void deleteWarehouse(long id) {
		warehouseRepository.deleteById(id);
	}
}
