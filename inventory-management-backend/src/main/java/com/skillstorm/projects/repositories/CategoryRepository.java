package com.skillstorm.projects.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.projects.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	public List<Category>findByName(String name);
}
