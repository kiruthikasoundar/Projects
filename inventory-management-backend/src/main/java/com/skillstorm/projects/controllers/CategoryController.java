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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.projects.dtos.CategoryDto;
import com.skillstorm.projects.services.CategoryService;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * GET request for retrieving all categories or filtering by name
	 *
	 * @Param name (optional) name of category to filter by
	 * @return a list of CategoryDto objects
	 */
	@GetMapping
	public List<CategoryDto> findAllCategories(@RequestParam(required = false) String name) {
		return categoryService.findAllCategories(name);
	}
	
	/**
	 * GET request for retrieving a single category by ID
	 *
	 * @Param id the ID of the category to retrieve
	 * @return a single CategoryDto object
	 */
	@GetMapping("/{id}")public CategoryDto findCategoryById(@PathVariable long id) {
		return categoryService.findCategoryById(id);
	}
	
	/**
	 * POST request for creating a new category
	 *
	 * @Param categoryData the CategoryDto object containing data for the new category
	 * @return a ResponseEntity containing the created CategoryDto object and HTTP status code 201 (Created)
	 */
	@PostMapping("/categories")
	public ResponseEntity<CategoryDto> createCategopry(@RequestBody CategoryDto categoryData){
		CategoryDto Category = categoryService.createCategory(categoryData);
		return new ResponseEntity<>(Category, HttpStatus.CREATED);
	}
	
	/**
	 * PUT request for updating an existing category
	 *
	 * @Param id the ID of the category to update
	 * @Param categoryData the CategoryDto object containing data to update the category with
	 * @return the updated CategoryDto object
	 */
	@PutMapping("/{id}")
	public CategoryDto updateCategory(@PathVariable long id, @RequestBody CategoryDto categoryData) {
		categoryData.setId(id);
		return categoryService.updateCategory(categoryData);
	}
	
	/**
	 * DELETE request for deleting an existing category
	 *
	 * @Param id the ID of the category to delete
	 */
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}
}
