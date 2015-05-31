package vn.fpt.fsoft.model;

public class Customer {

	private String name;
	private int phone;
	private String email;

	public void insertCard() {

	}

	public void enterPIN(char PIN) {

	}

	public boolean changPIN(char oldPIN, char newPIN) {

		return false;
	}

	public void withDraw(ATM inATM, Card inCard, int inAmount) {
		//
	}

	public void checkBalance(ATM inATM, Card inCard) {

	}

	public void transfer(ATM inATM, Card inCard, int inToAccount, int inAmount) {

	}

	public void viewHistory() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Customer o) {
		if ((this.getName() == o.getName())
				&& (this.getEmail() == o.getEmail())
				&& (this.getPhone() == o.getPhone())) {
			return true;
		}
		return false;
	}

}
