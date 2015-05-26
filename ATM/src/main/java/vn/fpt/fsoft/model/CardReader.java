package vn.fpt.fsoft.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.dao.UserDao;

@Component
public class CardReader {

	@Autowired
	private UserDao userDao;
	private Card card;
	
	public CardReader(){
		//EMTRY CONSTRUCTOR
	}
	
	public boolean acceptCard() {
		boolean check = false;
		
		if(card.getCardNo().length() > 5){
			check = true;
		}
		return check;
	}

	public String readCard() {
		
		return card.getCardNo();
	}
	
	public boolean validateCard(){
		
		return userDao.validateCard(readCard());
	}

	public void ejectCard() {

	}

	public boolean validatePIN() {
		
		return userDao.checkPIN(card.getCardNo(), card.getPIN());
	}

	public void swallowCard() {

	}

	public void checkAttempt() {
		
		//do something
	}
	
	public void setCard(Card card){
		this.card = card;
	}

}
