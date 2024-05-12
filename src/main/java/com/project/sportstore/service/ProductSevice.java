package com.project.sportstore.service;

import java.util.List;

import com.project.sportstore.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;


public interface ProductSevice {
	List<Product> getAll();

	List<Product> getOrderByNew(String sortOrder);

	Boolean create(Product product);

	Product findById(Integer id);
	
	List<Product> searchCategory(String keyword);
	
	List<Product> findByCategoryId(Integer categoryId);

	Boolean update(Product product);

	Boolean delete(Integer id);

	List<Product> findProductsByCategoryName(@Param("categoryName") String categoryName);

	List<Product> findAllOrderByPriceAsc(String sortOrder);

	List<Product> findAllOrderByPriceDESC(String sortOrder);

	List<Product> findByPrice(@Param("price") Double price);


	Page<Product> getAll(Integer pageNo);
	Page<Product> searchProduct(String keyword,Integer pageNo);
}
