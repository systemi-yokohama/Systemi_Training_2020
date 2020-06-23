package bean;

import java.sql.Date;

public class Home_comment_bean {
	String user_name;
	String write_category;
	String write_subject;
	String write_text;
	int write_id;
	int comment_write_id;
	String comment_text;
	Date write_created_date;

	public String getName() {
		return user_name;
	}

	public void setName(String user_name) {
		this.user_name = user_name;
	}

	public String getCategory() {
		return write_category;
	}

	public void setCategory(String write_category) {
		this.write_category = write_category;
	}

	public String getSubject() {
		return write_subject;
	}

	public void setSubject(String write_subject) {
		this.write_subject = write_subject;
	}

	public String getText() {
		return write_text;
	}

	public void setText(String write_text) {
		this.write_text = write_text;
	}

	public int getWrite_id() {
		return write_id;
	}

	public void setWrite_id(int write_id) {
		this.write_id = write_id;
	}

	public int getComment_write_id() {
		return comment_write_id;
	}

	public void setComment_write_id(int comment_write_id) {
		this.comment_write_id = comment_write_id;
	}

	public String getCommentText() {
		return comment_text;
	}

	public void setCommentText(String comment_text) {
		this.comment_text = comment_text;
	}

	public Date getWriteDate() {
		return write_created_date;
	}

	public void setWriteDate(Date write_created_date) {
		this.write_created_date = write_created_date;
	}

}
