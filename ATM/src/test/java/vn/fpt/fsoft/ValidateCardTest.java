package vn.fpt.fsoft;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;
import vn.fpt.fsoft.service.CardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml"})
public class ValidateCardTest {
	
	@Autowired
	private CardService cardService;
	@Autowired
	private CardReader cardReader;
	@Autowired
	private Card card;

	public static final String CARDNO_ACCEPT_BUT_NOTEXIST_DATABASE = "1234555";
	public static final String CARDNO_ACCEPT_EXIST_DATABASE = "1234567";
	
	@Test
	public void testValidateCardNotExistsDatabase(){
		card.setCardNo(CARDNO_ACCEPT_BUT_NOTEXIST_DATABASE);
		cardReader.setCard(card);
		
		assertFalse(cardService.validateCard(cardReader));
	}
	
	@Test
	public void testValidateCardExistsDatabase(){
		card.setCardNo(CARDNO_ACCEPT_EXIST_DATABASE);
		cardReader.setCard(card);
		
		assertTrue(cardService.validateCard(cardReader));
	}

}
