package com.project.sportstore.service;


import com.project.sportstore.model.ImageProduct;

public interface ImageProductSevice {
	Boolean create(ImageProduct imageProduct);
	Boolean deleteByProductId(Integer id);

}
