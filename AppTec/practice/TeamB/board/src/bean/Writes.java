package bean;

public class Writes {
	private int write_id;
	private String write_subject;
	private String write_text;
	private String write_category;
	private int write_user_id;
	private String write_created_date;
	private String write_update_date;

	private int user_id;


	public int getWrite_id() {
		return write_id;
	}
	public void setWrite_id(int write_id) {
		this.write_id = write_id;
	}
	public String getWrite_subject() {
		return write_subject;
	}
	public void setWrite_subject(String write_subject) {
		this.write_subject = write_subject;
	}
	public String getWrite_text() {
		return write_text;
	}
	public void setWrite_text(String write_text) {
		this.write_text = write_text;
	}
	public String getWrite_category() {
		return write_category;
	}
	public void setWrite_category(String write_category) {
		this.write_category = write_category;
	}
	public int getWrite_user_id() {
		return write_user_id;
	}
	public void setWrite_user_id(int write_user_id) {
		this.write_user_id = write_user_id;
	}
	public String getWrite_created_date() {
		return write_created_date;
	}
	public void setWrite_created_date(String write_created_date) {
		this.write_created_date = write_created_date;
	}
	public String getWrite_update_date() {
		return write_update_date;
	}
	public void setWrite_update_date(String write_update_date) {
		this.write_update_date = write_update_date;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
