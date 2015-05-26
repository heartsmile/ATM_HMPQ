package vn.fpt.fsoft.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

@Entity
public class Card implements Serializable{

	@Id
	@Length(max = 16)
	private String cardNo;
	@Length(max = 30)
	private String status;
	@ManyToOne
	@JoinColumn(name = "accountID")
	private Account accountID;
	@Length(max = 6)
	private String PIN;
	private Date startDate;
	private Date expiredDate;
	private Integer attempt;
	@OneToMany(mappedBy ="cardNo")
	private Set<Log> logs;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Integer getAttempt() {
		return attempt;
	}

	public void setAttempt(Integer attempt) {
		this.attempt = attempt;
	}

	public Account getAccountID() {
		return accountID;
	}

	public void setAccountID(Account accountID) {
		this.accountID = accountID;
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}


	
}
