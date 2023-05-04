package com.skillstorm.projects.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.projects.dtos.ProductDto;
import com.skillstorm.projects.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("select p from Product p where p.category.id = ?1")
	public List<Product>findAllProductByCategoryId(long id);
}
