package vn.fpt.fsoft.model;

import java.util.Date;

public class Card {

	private char cardNo;
	private char PIN;
	private Date startDate;
	private Date expriedDate;
	private int account;
	public String status;
	private int attempt;

	public char getPIN() {
		return PIN;
	}

	public void setPIN(char pIN) {
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
