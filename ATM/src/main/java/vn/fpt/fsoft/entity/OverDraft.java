package vn.fpt.fsoft.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OverDraft {

	@Id
	private Integer oDID;
	private Float value;
	@OneToMany(mappedBy = "oDID")
	private Set<Account> accounts;

	public Integer getoDID() {
		return oDID;
	}

	public void setoDID(Integer oDID) {
		this.oDID = oDID;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	
}
