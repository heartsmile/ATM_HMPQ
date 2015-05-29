
package vn.fpt.fsoft;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;
import vn.fpt.fsoft.service.UserService;

@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml"})
public class AutheticateTest{

	@Autowired
	private UserService userService;
	@Autowired
	private CardReader cardReader;
	@Autowired
	private Card card;
	public int attempt = 1;

	@Before
	public void setUp(){
		card.setCardNo("123465");
		card.setPIN("131356");
		cardReader.setCard(card);
		attempt = card.getAttempt();
	}
	
	@Test
	public void firstAttemptTest(){
		
		assertFalse(userService.auth(cardReader, card, attempt));
	}
	
	@Test
	public void secondAttemptTest(){
		
		assertFalse(userService.auth(cardReader, card, attempt));
	}
	
	@Test
	public void thirdAttemptTest(){
		
		assertFalse(userService.auth(cardReader, card, attempt));
	}
	
	@Test
	public void authTest(){
		card.setCardNo("123456");
		card.setPIN("123");
		cardReader.setCard(card);
		attempt = card.getAttempt();
		
		assertTrue(userService.auth(cardReader, card, attempt));
	}
	
}
