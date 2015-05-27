package vn.fpt.fsoft.model;

public class Money {

	private int quantity;
	private int value;
	
	public Money(int quantity, int value) {
		this.quantity = quantity;
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
