package com.skillstorm.projects.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillstorm.projects.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	/**
	 * Finds a list of categories by name.
	 * @Param name The name of the category.
	 * @return List of categories that match the name.
	 */
	public List<Category>findByName(String name);
}
