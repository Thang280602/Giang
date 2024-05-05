package com.project.sportstore.repository;

import com.project.sportstore.model.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import jakarta.transaction.Transactional;

@Transactional
public interface ImageProductRepository extends JpaRepository<ImageProduct, Integer> {
	@Modifying
	@Query("Delete from ImageProduct i Where i.product.id=?1")
	void deleteByProductId(Integer id);
}
