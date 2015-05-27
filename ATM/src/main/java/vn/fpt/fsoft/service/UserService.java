package vn.fpt.fsoft.service;

import org.springframework.stereotype.Service;

import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;

@Service
public class UserService {

	public boolean auth(CardReader cardReader, Card card,int attempt){
		boolean check = false;

		if (attempt <= 3) {
			
			if (cardReader.validatePIN()) {
				check = true;
			} else {
				
				if(attempt == 3){
					card.block();
					cardReader.swallowCard();
				}
				
			}
		}
		
		return check;
	}
}
