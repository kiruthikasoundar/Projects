package com.skillstorm.projects.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.skillstorm.projects.dtos.ProductDto;
import com.skillstorm.projects.models.Category;
import com.skillstorm.projects.models.Product;
import com.skillstorm.projects.repositories.CategoryRepository;
import com.skillstorm.projects.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * Finds all products belonging to a category with the specified ID.
	 *
	 * @Param id the ID of the category to search for
	 * @return a List of ProductDto objects representing the products found
	 */
	public List<ProductDto> findAllProductByCategoryId(long id) {
		return productRepository.findAllProductByCategoryId(id)
				.stream()
				.map(p -> p.toDto())
				.toList();
	}
	
	/**
	 * Creates a new product with the specified information.
	 *
	 * @Param productData a ProductDto object representing the product to create
	 * @return a ProductDto object representing the newly created product
	 */
	public ProductDto createProduct(ProductDto productData) {
		Category category = categoryRepository.findById(productData.getCategoryId())
				.orElseThrow();
		Product product = new Product(productData.getId(),productData.getName(),productData.getPrice(),category);
		return productRepository.save(product).toDto();
	}

	/**
	 * Finds all products in the system.
	 *
	 * @return a List of ProductDto objects representing the products found
	 */
	public List<ProductDto> findAllProduct() {
		return productRepository.findAll()
				.stream()
				.map(w -> w.toDto())
				.toList();
	}

	/**
	 * Updates an existing product with the specified information.
	 *
	 * @Param productData a ProductDto object representing the updated product information
	 * @return a ProductDto object representing the updated product
	 */
	public ProductDto updateProduct(ProductDto productData) {
		Category category = categoryRepository.findById(productData.getCategoryId())
				.orElseThrow();
		Product product = new Product(productData.getId(),productData.getName(),productData.getPrice(),category);
		return productRepository.save(product).toDto();
	}

	/**
	 * Deletes the product with the specified ID.
	 *
	 * @Param id the ID of the product to delete
	 */
	public void deleteProductById(long id) {
		productRepository.deleteById(id);
		
	}
}
