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
	@JoinColumn(name = "custID")
	private Customer custID;
	@ManyToOne
	@JoinColumn(name = "oDID")
	private OverDraft oDID;
	@ManyToOne
	@JoinColumn(name = "wDID")
	private WithDraw wDID;
	@Length(max = 50)
	private String accountNo;
	private Float balance;

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

	public Customer getCustID() {
		return custID;
	}

	public void setCustID(Customer custID) {
		this.custID = custID;
	}

	public OverDraft getoDID() {
		return oDID;
	}

	public void setoDID(OverDraft oDID) {
		this.oDID = oDID;
	}

	public WithDraw getwDID() {
		return wDID;
	}

	public void setwDID(WithDraw wDID) {
		this.wDID = wDID;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

}
