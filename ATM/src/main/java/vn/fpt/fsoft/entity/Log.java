package vn.fpt.fsoft.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

@Entity
public class Log {

	@Id
	private Integer logID;
	@ManyToOne
	@JoinColumn(name = "logTypeID")
	private LogType logTypeID;
	@ManyToOne
	@JoinColumn(name = "atmid", insertable = false, updatable = false)
	private ATM atm;
	@ManyToOne
	@JoinColumn(name = "cardNo", insertable = false, updatable = false)
	@Length(max = 16)
	private Card card;
	private Date logDate;
	private Float amount;
	@Length(max = 100)
	private String details;
	private Integer atmid;
	private String cardNo;

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

	public Integer getAtmid() {
		return atmid;
	}

	public void setAtmid(Integer atmid) {
		this.atmid = atmid;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
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
