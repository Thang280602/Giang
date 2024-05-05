package com.project.sportstore.service;

import com.project.sportstore.model.CardItem;
import com.project.sportstore.repository.CardItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CardItemSeviceImpl implements CardItemSevice{
	@Autowired
	private CardItemRepository cardItemRepository;
	@Override
	public Boolean add(CardItem cardItem) {
		try {
			this.cardItemRepository.save(cardItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CardItem update(CardItem cardItem) {
		// TODO Auto-generated method stub
		return this.cardItemRepository.save(cardItem);
	}

	@Override
	public CardItem findId(Integer id) {
		// TODO Auto-generated method stub
		return this.cardItemRepository.findById(id).get();
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.cardItemRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CardItem checkCardItem(Integer cardId, Integer productId) {
		// TODO Auto-generated method stub
		return this.cardItemRepository.findByCardIdAndProductId(cardId,productId);
	}

	@Override
	public Boolean deleteByProductId(Integer productId) {
		try {
			this.cardItemRepository.deleteByProductId(productId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void deleteByCardId(Integer cardId) {
		this.cardItemRepository.deleteByCardId(cardId);
		
	}

	@Override
	public void updateCard(Integer quantity) {
		 this.cardItemRepository.updateCard(quantity);
	}




}
