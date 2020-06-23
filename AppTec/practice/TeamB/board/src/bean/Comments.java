package bean;

import java.sql.Date;

public class Comments {
	int comment_id;
	String comment_text;
	int comment_user;
	int comment_write_id;
	Date comment_created_data;
	Date comment_update_date;
	int user_id;

	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public int getComment_user() {
		return comment_user;
	}
	public void setComment_user(int comment_user) {
		this.comment_user = comment_user;
	}
	public int getComment_write_id() {
		return comment_write_id;
	}
	public void setComment_write_id(int comment_write_id) {
		this.comment_write_id = comment_write_id;
	}
	public Date getComment_created_data() {
		return comment_created_data;
	}
	public void setComment_created_data(Date comment_created_data) {
		this.comment_created_data = comment_created_data;
	}
	public Date getComment_update_date() {
		return comment_update_date;
	}
	public void setComment_update_date(Date comment_update_date) {
		this.comment_update_date = comment_update_date;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


}
