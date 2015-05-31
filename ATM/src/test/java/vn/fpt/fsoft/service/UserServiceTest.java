package vn.fpt.fsoft.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import vn.fpt.fsoft.model.Account;
import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml",
		"classpath:servlet-context.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;
	@Autowired
	private Card card;
	@Autowired
	private CardReader cardReader;
	
	public static final String CARDNO_ACCEPT = "1234567";
	
	
	@Test
	public void testGetAccountNotNull(){
		card.setCardNo(CARDNO_ACCEPT);
		cardReader.setCard(card);
		
	 	Assert.notNull(userService.getAccount(card));
	}
	
	@Test
	public void testGetAccountEquals(){
		card.setCardNo(CARDNO_ACCEPT);
		cardReader.setCard(card);
		
		Account account = userService.getAccount(card);
		
		Account expected = new Account();
		expected.setAccountID(123456);
		expected.setBalance((float) 2.0E8);
		expected.setCustomer(null);
		
		Assert.isTrue(expected.equals(account));
	}
	
	@Test
	public void testGetAccountNotEquals(){
		card.setCardNo(CARDNO_ACCEPT);
		cardReader.setCard(card);
		
		Account account = userService.getAccount(card);
		
		Account expected = new Account();
		expected.setAccountID(123456);
		expected.setBalance((float) 2.0E7);
		expected.setCustomer(null);
		
		Assert.isTrue(!expected.equals(account));
	}
}
