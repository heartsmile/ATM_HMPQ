package vn.fpt.fsoft.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ATM {

	@Id
	private Integer atmid;
	private String branch;
	private String address;
	@OneToMany(mappedBy = "atmid")
	private Set<Log> logs;
	@OneToMany(mappedBy = "atmid")
	private Set<Stock> stocks;

	public Integer getAtmid() {
		return atmid;
	}

	public void setAtmid(Integer atmid) {
		this.atmid = atmid;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	

}
