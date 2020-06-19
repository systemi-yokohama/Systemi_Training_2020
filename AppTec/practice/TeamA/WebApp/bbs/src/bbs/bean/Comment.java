package bbs.bean;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	private String text;
	private String userAccount;
	private int contributionId;
	private Date createdDate;
	private Date updatedDate;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public int getContributionId() {
		return contributionId;
	}
	public void setContributionId(int contributionId) {
		this.contributionId = contributionId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
