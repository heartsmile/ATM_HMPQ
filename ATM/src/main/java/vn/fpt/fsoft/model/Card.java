package vn.fpt.fsoft.model;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.dao.CardDao;

@Component
public class Card {

	private String cardNo;
	private String PIN;
	private Date startDate;
	private Date expriedDate;
	private int account;
	public String status;
	private int attempt;
	
	@Autowired
	private CardDao cardDao;
	
	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public int getAttempt() {
		attempt +=1;
		return attempt;
	}

	public void block() {
		attempt = 0;
		cardDao.block(cardNo);
	}

	public void unBlock() {

	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public int getAccount(){
		return cardDao.getAccountID(cardNo);
	}

	public void setAccount(int account) {
		this.account = account;
	}

	
}
