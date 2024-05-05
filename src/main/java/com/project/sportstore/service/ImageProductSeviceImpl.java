package com.project.sportstore.service;

import com.project.sportstore.model.ImageProduct;
import com.project.sportstore.repository.ImageProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ImageProductSeviceImpl implements ImageProductSevice{
	@Autowired
	public ImageProductRepository imageProductRepository;
	@Override
	public Boolean create(ImageProduct imageProduct) {
		try {
			this.imageProductRepository.save(imageProduct);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Boolean deleteByProductId(Integer id) {
		try {
			this.imageProductRepository.deleteByProductId(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
