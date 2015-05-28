package vn.fpt.fsoft.model;

import org.springframework.stereotype.Component;

@Component
public class Money {

	private int quantity;
	private int value;

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
