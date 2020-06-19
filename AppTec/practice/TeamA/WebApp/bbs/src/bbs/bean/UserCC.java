package bbs.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserCC implements Serializable {
	private static final long serialVersionUID = 1L;

	 private String cbUserAccount;
	 private int cbId;
     private String cbTitle;
     private String cbText;
     private String cbCategory;
     private Date cbCreatedDate;
     private List<Comment> comments;


	public String getCbUserAccount() {
		return cbUserAccount;
	}
	public void setCbUserAccount(String cbUserAccount) {
		this.cbUserAccount = cbUserAccount;
	}
	public int getCbId() {
		return cbId;
	}
	public void setCbId(int cbId) {
		this.cbId = cbId;
	}
	public String getCbTitle() {
		return cbTitle;
	}
	public void setCbTitle(String cbTitle) {
		this.cbTitle = cbTitle;
	}
	public String getCbText() {
		return cbText;
	}
	public void setCbText(String cbText) {
		this.cbText = cbText;
	}
	public String getCbCategory() {
		return cbCategory;
	}
	public void setCbCategory(String cbCategory) {
		this.cbCategory = cbCategory;
	}
	public Date getCbCreatedDate() {
		return cbCreatedDate;
	}
	public void setCbCreatedDate(Date cbCreatedDate) {
		this.cbCreatedDate = cbCreatedDate;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
