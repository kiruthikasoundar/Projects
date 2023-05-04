package com.skillstorm.projects.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<CategoryDto> findAllCategories(@RequestParam(required = false) String name) {
		return categoryService.findAllCategories(name);
	}
	
	@GetMapping("/{id}")public CategoryDto findCategoryById(@PathVariable long id) {
		return categoryService.findCategoryById(id);
	}
	
	@PostMapping("/categories")
	public ResponseEntity<CategoryDto> createCategopryDto(@RequestBody CategoryDto categoryData){
		CategoryDto Category = categoryService.createCategory(categoryData);
		return new ResponseEntity<>(Category, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public CategoryDto updateCategory(@PathVariable long id, @RequestBody CategoryDto categoryData) {
		categoryData.setId(id);
		return categoryService.updateCategory(categoryData);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}
}
