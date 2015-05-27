package vn.fpt.fsoft.service;

import org.springframework.stereotype.Service;

import vn.fpt.fsoft.entity.Card;
import vn.fpt.fsoft.model.CardReader;

@Service
public class CardService {

	public boolean acceptCard(CardReader cardReader){
		return cardReader.acceptCard();
	}
	
	public boolean validateCard(CardReader cardReader){
		return cardReader.validateCard();
	}
}
