package vn.fpt.fsoft.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account implements Serializable{

	@Id
	private Integer accountID;
	private Customer custID;
//	private OverDraftLimit oDID;
//	private WithDrawLimit wDID;
	private String accountNo;
	private Integer balance;

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Customer getCustID() {
		return custID;
	}

	public void setCustID(Customer custID) {
		this.custID = custID;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "oDID", nullable = false)
//	public OverDraftLimit getoDID() {
//		return oDID;
//	}
//
//	public void setoDID(OverDraftLimit oDID) {
//		this.oDID = oDID;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "wDID", nullable = false)
//	public WithDrawLimit getwDID() {
//		return wDID;
//	}
//
//	public void setwDID(WithDrawLimit wDID) {
//		this.wDID = wDID;
//	}
	
	
	

}
