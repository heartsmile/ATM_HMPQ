package vn.fpt.fsoft.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stock {

	@Id
	private Integer stockID;
	@ManyToOne
	@JoinColumn(name = "moneyID")
	private Money moneyID;
	@ManyToOne
	@JoinColumn(name = "atmid")
	private ATM atmid;
	private Integer quantity;
	public Integer getStockID() {
		return stockID;
	}
	public void setStockID(Integer stockID) {
		this.stockID = stockID;
	}
	public Money getMoneyID() {
		return moneyID;
	}
	public void setMoneyID(Money moneyID) {
		this.moneyID = moneyID;
	}
	public ATM getAtmid() {
		return atmid;
	}
	public void setAtmid(ATM atmid) {
		this.atmid = atmid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
