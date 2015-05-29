package vn.fpt.fsoft.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import vn.fpt.fsoft.model.CardReader;

@Service
public class CardService {
	final static Logger logger = Logger.getLogger(CardService.class);
	
	public boolean acceptCard(CardReader cardReader){
		return cardReader.acceptCard();
	}
	
	public boolean validateCard(CardReader cardReader){
		return cardReader.validateCard();
	}
}
