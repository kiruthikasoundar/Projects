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
import org.springframework.web.bind.annotation.RestController;
import com.skillstorm.projects.dtos.ProductDto;
import com.skillstorm.projects.services.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Retrieves a list of products for a given category id.
	 *
	 * @Param id the id of the category to retrieve products for
	 * @return a list of ProductDto objects
	 */
	@GetMapping("/categories/{id}/products")
	public List<ProductDto> findAllProductByCategoryId(@PathVariable long id) {
		return productService.findAllProductByCategoryId(id);
	}
	
	/**
	 * Creates a new product for a given category id.
	 *
	 * @Param id the id of the category to create a product for
	 * @Param productData the product data to create
	 * @return the created ProductDto object
	 */
	@PostMapping("/categories/{id}/products")
	public ProductDto createProductByCategoryId(@PathVariable long id, @RequestBody ProductDto productData) {
		productData.setId(id);
		return productService.createProduct(productData);
	}
	
	/**
	 * Retrieves a list of all products.
	 *
	 * @return a list of ProductDto objects
	 */
	@GetMapping("/products")
	public List<ProductDto>findAllProduct(){
		return productService.findAllProduct();
	}
	
	/**
	 * Creates a new product.
	 *
	 * @Param productData the product data to create
	 * @return the created ProductDto object
	 */
	@PostMapping("/products")
	public ResponseEntity<ProductDto>createProduct(@RequestBody ProductDto productData){
		ProductDto Product = productService.createProduct(productData);
		return new ResponseEntity<>(Product, HttpStatus.CREATED);
	}
	
	/**
	 * Updates an existing product by id.
	 *
	 * @Param id the id of the product to update
	 * @Param productData the updated product data
	 * @return the updated ProductDto object
	 */
	@PutMapping("/products/{id}")
	public ProductDto updateProduct(@PathVariable long id, @RequestBody ProductDto productData) {
		productData.setId(id);
		return  productService.updateProduct(productData);
	}
	
	/**
	 * Deletes a product by id.
	 *
	 * @Param id the id of the product to delete
	 */
	@DeleteMapping("products/{id}")
	public void deleteProductById(@PathVariable long id) {
	    productService.deleteProductById(id);
	}
}
