package vn.fpt.fsoft.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WithDraw {

	@Id
	private Integer wDID;
	private Float value;
	@OneToMany(mappedBy = "wDID")
	private Set<Account> accounts;
	
	public Integer getwDID() {
		return wDID;
	}

	public void setwDID(Integer wDID) {
		this.wDID = wDID;
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
