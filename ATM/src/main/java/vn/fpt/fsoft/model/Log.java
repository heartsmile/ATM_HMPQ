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
}
