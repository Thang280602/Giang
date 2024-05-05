package com.project.sportstore.service;


import com.project.sportstore.model.Card;
import com.project.sportstore.model.CardItem;
import com.project.sportstore.model.User;

import java.util.List;

public interface CardSevice {
	Boolean addCard(Card card);
	Long check(Long idUser);
	Card findByUser(User user);
	List<CardItem> findByCartId(Integer cartId);
}
