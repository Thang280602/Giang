package com.project.sportstore.service;

import java.util.List;

import com.project.sportstore.model.CardItem;

public interface CardItemSevice {
	Boolean add(CardItem cardItem);
	CardItem update(CardItem cardItem);
	CardItem findId(Integer id);
	Boolean delete(Integer id);
	Boolean deleteByProductId(Integer productId);
	CardItem checkCardItem(Integer cardId,Integer productId);
	void deleteByCardId(Integer cardId);
	void updateCard(Integer quantity);
	
}
