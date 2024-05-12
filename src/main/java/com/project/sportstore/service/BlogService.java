package com.project.sportstore.service;


import com.project.sportstore.model.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogService {
	List<Blog> getAll();

	Boolean create(Blog blog);

	Blog findById(Integer id);

	Boolean update(Blog blog);

	Boolean delete(Integer id);

	List<Blog> searchCategory(String keyword);

	Page<Blog> getAll(Integer pageNo);

	Page<Blog> searchCategory(String keyword, Integer pageNo);
}
