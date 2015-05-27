package vn.fpt.fsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;

@Service
public class UserService {

	@Autowired
	private CardReader cardReader;
	@Autowired
	private Card card;
	
	public String auth(CardReader cardReader, Card card){
		
		return "";
	}
}
