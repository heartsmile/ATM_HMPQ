package vn.fpt.fsoft.model;

import org.springframework.stereotype.Component;

@Component
public class Account {
	private int accountID;
	private Float balance;
	private Customer customer;

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
