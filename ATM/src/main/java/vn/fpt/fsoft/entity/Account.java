package vn.fpt.fsoft.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

@Entity
public class Account implements Serializable {

	@Id
	private Integer accountID;
	@ManyToOne
	@JoinColumn(name = "custID",insertable = false, updatable = false)
	private Customer cust;
	@ManyToOne
	@JoinColumn(name = "oDID",insertable = false, updatable = false)
	private OverDraft overDraft;
	@ManyToOne
	@JoinColumn(name = "wDID",insertable = false, updatable = false)
	private WithDraw withDraw;
	@Length(max = 50)
	private String accountNo;
	private Float balance;
	private Integer oDID;
	private Integer wDID;
	private Integer custID;

	@OneToMany(mappedBy = "accountID")
	private Set<Card> cards;

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public OverDraft getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(OverDraft overDraft) {
		this.overDraft = overDraft;
	}

	public WithDraw getWithDraw() {
		return withDraw;
	}

	public void setWithDraw(WithDraw withDraw) {
		this.withDraw = withDraw;
	}

	public Integer getoDID() {
		return oDID;
	}

	public void setoDID(Integer oDID) {
		this.oDID = oDID;
	}

	public Integer getwDID() {
		return wDID;
	}

	public void setwDID(Integer wDID) {
		this.wDID = wDID;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	public Integer getCustID() {
		return custID;
	}

	public void setCustID(Integer custID) {
		this.custID = custID;
	}
	
	

}
