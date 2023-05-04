package com.skillstorm.projects.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.projects.dtos.ProductDto;
import com.skillstorm.projects.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/categories/{id}/products")
	public List<ProductDto> findAllProductByCategoryId(@PathVariable long id) {
		return productService.findAllProductByCategoryId(id);
	}
	
	@PostMapping("/categories/{id}/products")
	public ProductDto createProductByCategoryId(@PathVariable long id, @RequestBody ProductDto productData) {
		productData.setId(id);
		return productService.createProduct(productData);
	}
	
//	@DeleteMapping("/products/{id}")
//	public void deleteProductById(@PathVariable long id) {
//	    productService.deleteProductById(id);
//	}
}
