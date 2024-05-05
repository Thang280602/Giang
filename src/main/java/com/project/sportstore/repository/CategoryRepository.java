package com.project.sportstore.repository;

import java.util.List;

import com.project.sportstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
	@Query("SELECT c FROM Category c where c.categoryName like %?1%")
	List<Category> searchCategory(String keyword);
	List<Category> findByCategoryStatus(Boolean categoryStatus);
}
