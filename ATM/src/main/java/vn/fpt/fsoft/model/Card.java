package vn.fpt.fsoft.model;

import java.util.Date;

import javax.annotation.PostConstruct;

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
	private String accountNo;
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
		attempt = cardDao.getAttempt(cardNo);
		return attempt;
	}
	
	public void setAttempt(int count){
		cardDao.setAttempt(cardNo,count);
	}

	public void block() {
		//attempt = 0;
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
	
	public String getAccountNo(){
		return cardDao.getAccountNo(cardNo);
	}

	public void setAccountNo(String account) {
		this.accountNo = account;
	}

	public void reset(){
		attempt = 0;
	}
	
}
