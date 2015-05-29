package vn.fpt.fsoft;


import static org.junit.Assert.assertFalse;

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
public class AcceptCardTest {

	@Autowired
	private CardService cardService;
	@Autowired
	private CardReader cardReader;
	@Autowired
	private Card card;
	public static final String CARDNO_NOT_ACCEPT = "123";
	public static final String CARDNO_ACCEPT = "123456465";
	
	@Test
	public void testAcceptCardNotAccept() {
		card.setCardNo(CARDNO_NOT_ACCEPT);
		cardReader.setCard(card);
		
		assertFalse(cardService.acceptCard(cardReader));
	}
	
	public void testAcceptCardAccept() {
		card.setCardNo(CARDNO_ACCEPT);
		cardReader.setCard(card);
		
		assertFalse(cardService.acceptCard(cardReader));
	}
	
}
