package com.project.sportstore.service;

import java.util.List;

import com.project.sportstore.model.Product;
import com.project.sportstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ProductImpl implements ProductSevice {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}



	@Override
	public Boolean create(Product product) {
		try {
			this.productRepository.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(id).get();
	}

	@Override
	public Boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			this.productRepository.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			this.productRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> findProductsByCategoryName(String categoryName) {
		return this.productRepository.findProductsByCategoryName(categoryName);
	}

	@Override
	public List<Product> findAllOrderByPriceAsc(String sortOrder) {
		// TODO Auto-generated method stub
		return this.productRepository.findAllOrderByPriceAsc(sortOrder);
	}

	@Override
	public List<Product> findAllOrderByPriceDESC(String sortOrder) {
		// TODO Auto-generated method stub
		return this.productRepository.findAllOrderByPriceDesc(sortOrder);
	}

	@Override
	public List<Product> getOrderByNew(String sortOrder) {
		// TODO Auto-generated method stub
		return this.productRepository.findAllOrderByNameAsc(sortOrder);
	}

	@Override
	public List<Product> findByPrice(Double price) {
		// TODO Auto-generated method stub
		return this.productRepository.findByPrice(price);
	}



	@Override
	public List<Product> findByCategoryId(Integer categoryId) {
		
		return this.productRepository.findByCategoryId(categoryId);
	}

	@Override
	public List<Product> searchCategory(String keyword) {
		return this.productRepository.searchCategory(keyword);
	}

	@Override
	public Page<Product> getAll(Integer pageNo) {
		PageRequest pageable = PageRequest.of(pageNo-1, 6);
		return this.productRepository.findAll(pageable);
	}

	@Override
	public Page<Product> searchProduct(String keyword, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
