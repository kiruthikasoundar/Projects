package com.skillstorm.projects.services;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<ProductDto> findAllProductByCategoryId(long id) {
		return productRepository.findAllProductByCategoryId(id)
				.stream()
				.map(p -> p.toDto())
				.toList();
	}
	

	public ProductDto createProduct(ProductDto productData) {
		Category category = categoryRepository.findById(productData.getCategoryId())
				.orElseThrow();
		Product product = new Product(productData.getId(),productData.getName(),productData.getPrice(),category);
		return productRepository.save(product).toDto();
	}


	public void deleteProductById(long id) {
		productRepository.deleteById(id);
		
	}
}
