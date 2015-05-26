package vn.fpt.fsoft.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Log {

	@Id
	private Integer logID;
	@ManyToOne
	@JoinColumn(name = "logTypeID")
	private LogType logTypeID;
	@ManyToOne
	@JoinColumn(name = "atmid")
	private ATM atmid;
	@ManyToOne
	@JoinColumn(name = "cardNo")
	private Card cardNo;
	private Date logDate;
	private Float amount;
	private String details;

	public Integer getLogID() {
		return logID;
	}

	public void setLogID(Integer logID) {
		this.logID = logID;
	}

	public LogType getLogTypeID() {
		return logTypeID;
	}

	public void setLogTypeID(LogType logTypeID) {
		this.logTypeID = logTypeID;
	}

	public ATM getAtmid() {
		return atmid;
	}

	public void setAtmid(ATM atmid) {
		this.atmid = atmid;
	}

	public Card getCardNo() {
		return cardNo;
	}

	public void setCardNo(Card cardNo) {
		this.cardNo = cardNo;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
