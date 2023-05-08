package com.skillstorm.projects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.projects.dtos.CategoryDto;
import com.skillstorm.projects.models.Category;
import com.skillstorm.projects.repositories.CategoryRepository;

/**
 * Service layer class that provides CRUD operations for Category entities.
 */
@Service
@Transactional
public class CategoryService {

	/**
	 * The CategoryRepository instance used to access the database.
	 */
	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * Retrieves all Category entities from the database or by name if provided.
	 * 
	 * @Param name the name of the Category entities to retrieve or null to retrieve all Categories.
	 * @return a List of CategoryDto objects representing the retrieved Category entities.
	 */
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
	
	/**
	 * Retrieves a Category entity by its id.
	 * 
	 * @Param id the id of the Category entity to retrieve.
	 * @return a CategoryDto object representing the retrieved Category entity.
	 * @throws NoSuchElementException if no Category entity with the provided id exists.
	 */
	public CategoryDto findCategoryById(long id) {
		return categoryRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	/**
	 * Creates a new Category entity.
	 * 
	 * @Param categoryData a CategoryDto object representing the new Category entity to create.
	 * @return a CategoryDto object representing the created Category entity.
	 */
	public CategoryDto createCategory(CategoryDto categoryData) {
		Category category = new Category(categoryData.getId(),categoryData.getName(),categoryData.getDescription());
		return categoryRepository.save(category).toDto();
	}
	
	/**
	 * Updates an existing Category entity.
	 * 
	 * @Param categoryData a CategoryDto object representing the Category entity to update.
	 * @return a CategoryDto object representing the updated Category entity.
	 */
	public CategoryDto updateCategory(CategoryDto categoryData) {
		Category category = new Category(categoryData.getId(),categoryData.getName(),categoryData.getDescription());
		return categoryRepository.save(category).toDto();
	}
	
	/**
	 * Deletes a Category entity by its id.
	 * 
	 * @Param id the id of the Category entity to delete.
	 */
	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}
}
