package vn.fpt.fsoft.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

@Entity
public class Money {

	@Id
	private Integer moneyID;
	private Float moneyValue;
	@Length(max = 100)
	private String address;
	@OneToMany(mappedBy = "moneyID")
	private Set<Stock> stocks;
	
	public Integer getMoneyID() {
		return moneyID;
	}

	public void setMoneyID(Integer moneyID) {
		this.moneyID = moneyID;
	}
	
	public Float getMoneyValue() {
		return moneyValue;
	}

	public void setMoneyValue(Float moneyValue) {
		this.moneyValue = moneyValue;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
	
	

}
