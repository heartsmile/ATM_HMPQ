package vn.fpt.fsoft.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

@Entity
public class LogType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer logTypeID;
	@Length(max = 100)
	private String description;
	@OneToMany(mappedBy = "logTypeID")
	private Set<Log> logs;

	public Integer getLogTypeID() {
		return logTypeID;
	}

	public void setLogTypeID(Integer logTypeID) {
		this.logTypeID = logTypeID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}
	
	

}
