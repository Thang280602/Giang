package com.project.sportstore.repository;

import java.util.List;

import com.project.sportstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.category.categoryName = :categoryName")
	List<Product> findProductsByCategoryName(@Param("categoryName") String categoryName);

	@Query("SELECT c FROM Product c where c.productName like %?1%")
	List<Product> searchCategory(String keyword);

	@Query("SELECT p FROM Product p ORDER BY p.price ASC")
	List<Product> findAllOrderByPriceAsc(String sortOrder);

	@Query("SELECT p FROM Product p ORDER BY p.price DESC")
	List<Product> findAllOrderByPriceDesc(String sortOrder);
	@Query("SELECT p FROM Product p ORDER BY p.productName ASC")
	List<Product> findAllOrderByNameAsc(String sortOrder);
	@Query("SELECT p FROM Product p WHERE p.price <= :price")
	List<Product> findByPrice(@Param("price") Double price);


	@Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
	List<Product> findByCategoryId(@Param("categoryId") Integer categoryId);

}
