package com.skillstorm.projects.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.skillstorm.projects.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	/**
	 * This method finds all the products associated with a given category id.
	 * @Param id the id of the category to find the products for
	 * @return a list of products that belong to the category with the given id
	 */
	@Query("select p from Product p where p.category.id = ?1")
	public List<Product>findAllProductByCategoryId(long id);
	
}
