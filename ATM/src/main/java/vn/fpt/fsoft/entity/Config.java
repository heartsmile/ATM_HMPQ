package vn.fpt.fsoft.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Config {

	@Id
	private Integer configID;
	private Date dateModified;
	private Integer minWithDraw;
	private Integer maxWithDraw;
	@Transient
	private int numPerPage;

	public Integer getConfigID() {
		return configID;
	}

	public void setConfigID(Integer configID) {
		this.configID = configID;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public Integer getMinWithDraw() {
		return minWithDraw;
	}

	public void setMinWithDraw(Integer minWithDraw) {
		this.minWithDraw = minWithDraw;
	}

	public Integer getMaxWithDraw() {
		return maxWithDraw;
	}

	public void setMaxWithDraw(Integer maxWithDraw) {
		this.maxWithDraw = maxWithDraw;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

}
