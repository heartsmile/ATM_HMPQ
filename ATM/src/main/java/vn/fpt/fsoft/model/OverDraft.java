package vn.fpt.fsoft.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OverDraft {

	@Id
	private Integer oDID;
	private BigDecimal value;
	@OneToMany(mappedBy = "oDID")
	private Set<Account> accounts;

	public Integer getoDID() {
		return oDID;
	}

	public void setoDID(Integer oDID) {
		this.oDID = oDID;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	
}
