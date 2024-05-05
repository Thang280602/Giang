package com.project.sportstore.service;

import java.util.List;

import com.project.sportstore.model.Category;
import org.springframework.data.domain.Page;



public interface CategorySevice {
	List<Category> getAll();
	Boolean create(Category category);
	Category findById(Integer id);
	Boolean update (Category category);
	Boolean delete(Integer id);
	List<Category> searchCategory(String keyword);
	Page<Category> getAll(Integer pageNo);
	Page<Category> searchCategory(String keyword,Integer pageNo);
	List<Category> findByCategoryStatus(Boolean categoryStatus);
	
}