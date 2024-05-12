package com.project.sportstore.repository;

import com.project.sportstore.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	@Query("SELECT c FROM Blog c where c.blogName like %?1%")
	List<Blog> searchCategory(String keyword);
}
