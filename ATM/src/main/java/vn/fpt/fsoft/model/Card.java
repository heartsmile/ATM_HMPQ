package vn.fpt.fsoft.model;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Card {

	private char cardNo;
	private String PIN;
	private Date startDate;
	private Date expriedDate;
	private int account;
	public String status;
	private int attempt;

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getAttempt() {
		return attempt;
	}
	
	public void block(){
		
	}
	
	public void unBlock(){
		
	}

}
