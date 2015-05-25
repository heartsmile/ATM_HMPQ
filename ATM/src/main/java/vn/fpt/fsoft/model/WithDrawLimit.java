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
public class WithDrawLimit {

	@Id
	private Integer wDID;
	private BigDecimal value;

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


}
