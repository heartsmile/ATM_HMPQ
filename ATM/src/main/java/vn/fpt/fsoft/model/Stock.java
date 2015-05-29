package vn.fpt.fsoft.model;

import vn.fpt.fsoft.entity.Money;

public class Stock {
	private int stockID;
	private int moneyID;
	private int ATMID;
	private int quantity;
	
	public Money getAllMoney(int moneyID){
		return null;
	}

	public int getStockID() {
		return stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}

	public int getMoneyID() {
		return moneyID;
	}

	public void setMoneyID(int moneyID) {
		this.moneyID = moneyID;
	}

	public int getATMID() {
		return ATMID;
	}

	public void setATMID(int aTMID) {
		ATMID = aTMID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
