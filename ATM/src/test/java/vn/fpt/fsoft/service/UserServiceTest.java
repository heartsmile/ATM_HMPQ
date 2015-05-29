package vn.fpt.fsoft.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

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
		float balance = userService.getAccount(card).getBalance();
		float expected = 3000000f;
		
		Assert.isTrue(balance == expected);
	}
	
	@Test
	public void testGetAccountNotEquals(){
		card.setCardNo(CARDNO_ACCEPT);
		cardReader.setCard(card);
		
		float balance = userService.getAccount(card).getBalance();
		float checked = 300000f;
		
		Assert.isTrue(balance != checked);
	}
}
