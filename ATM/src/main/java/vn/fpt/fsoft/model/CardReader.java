package vn.fpt.fsoft.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.dao.UserDao;

@Component
public class CardReader {

	@Autowired
	private UserDao userDao;

	public boolean acceptCard() {

		return false;
	}

	public char readCard() {

		return 0;
	}

	public void ejectCard() {

	}

	public boolean validatePIN(Card card) {
		
		return userDao.checkPIN(card.getCardNo(), card.getPIN());
	}

	public void swallowCard() {

	}

	public void checkAttempt() {

	}

}
