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
public class WithDraw {

	@Id
	private Integer wDID;
	private BigDecimal value;
	@OneToMany(mappedBy = "wDID")
	private Set<Account> accounts;
	
	public Integer getwDID() {
		return wDID;
	}

	public void setwDID(Integer wDID) {
		this.wDID = wDID;
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
