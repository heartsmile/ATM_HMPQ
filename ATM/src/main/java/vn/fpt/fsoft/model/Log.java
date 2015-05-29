package vn.fpt.fsoft.model;

import vn.fpt.fsoft.entity.LogType;

public class Log {
	private int logID;
	private LogType logType;
	private ATM atm;
	private Card card;
	private float amount;
	private String details;

	public void writeLog() {

	}

	public Log readLog(ATM atm, Card card) {
		return null;
	}

	public int getLogID() {
		return logID;
	}

	public void setLogID(int logID) {
		this.logID = logID;
	}

	public LogType getLogType() {
		return logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
