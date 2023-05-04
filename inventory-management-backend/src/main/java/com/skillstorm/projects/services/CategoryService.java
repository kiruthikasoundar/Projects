package com.skillstorm.projects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.projects.dtos.CategoryDto;
import com.skillstorm.projects.models.Category;
import com.skillstorm.projects.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<CategoryDto>findAllCategories(String name){
		if(name == null) {
			return categoryRepository.findAll()
					.stream()
					.map(c -> c.toDto())
					.toList();
		}
		return categoryRepository.findByName(name)
					.stream()
					.map(c -> c.toDto())
					.toList();
	}
	
	public CategoryDto findCategoryById(long id) {
		return categoryRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	public CategoryDto createCategory(CategoryDto categoryData) {
		Category category = new Category(categoryData.getId(),categoryData.getName(),categoryData.getDescription());
		return categoryRepository.save(category).toDto();
	}
	
	public CategoryDto updateCategory(CategoryDto categoryData) {
		Category category = new Category(categoryData.getId(),categoryData.getName(),categoryData.getDescription());
		return categoryRepository.save(category).toDto();
	}
	
	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}
}
