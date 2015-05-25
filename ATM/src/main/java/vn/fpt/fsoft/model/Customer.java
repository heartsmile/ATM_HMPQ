package vn.fpt.fsoft.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable{

	@Id
	private Integer custID;
	private String name;
	private String phone;
	private String email;
	private String addr;
//	@ElementCollection(targetClass=Integer.class)
//	private Set<Account> account = new HashSet<Account>(0);
//	
	public Integer getCustID() {
		return custID;
	}

	public void setCustID(Integer custID) {
		this.custID = custID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

//	@OneToMany(fetch = FetchType.LAZY,mappedBy = "custID")
//	public Set<Account> getAccount() {
//		return account;
//	}
//
//	public void setAccount(Set<Account> account) {
//		this.account = account;
//	}
	
	

}
