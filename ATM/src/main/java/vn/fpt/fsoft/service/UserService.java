package vn.fpt.fsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.fpt.fsoft.dao.AccountDao;
import vn.fpt.fsoft.model.Account;
import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;

@Service
public class UserService {

	@Autowired
	private AccountDao accountDao;

	public boolean auth(CardReader cardReader, Card card, int attempt) {
		boolean check = false;

		if (attempt <= 3) {

			if (cardReader.validatePIN()) {
				card.setAttempt(1);
				check = true;
			} else {

				if (attempt == 3) {
					card.block();
					card.setAttempt(1);
					cardReader.swallowCard();
				} else {
					card.setAttempt(attempt + 1);
				}

			}
		}

		return check;
	}

	public Account getAccount(Card card) {
		return accountDao.getAccount(card);
	}
}
