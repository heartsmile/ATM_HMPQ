package vn.fpt.fsoft.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OverDraftLimit {

	@Id
	private Integer oDID;
	private Integer value;

	public Integer getoDID() {
		return oDID;
	}

	public void setoDID(Integer oDID) {
		this.oDID = oDID;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
