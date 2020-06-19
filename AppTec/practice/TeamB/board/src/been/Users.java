package been;

import java.sql.Timestamp;

public class Users {
	int user_id;
	String user_account;
	String user_password;
	String user_name;
	String user_office;
	String user_department;
	String user_status;
	Timestamp user_created_date;
	Timestamp user_update_date;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_office() {
		return user_office;
	}
	public void setUser_office(String user_office) {
		this.user_office = user_office;
	}
	public String getUser_department() {
		return user_department;
	}
	public void setUser_department(String user_department) {
		this.user_department = user_department;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public Timestamp getUser_created_date() {
		return user_created_date;
	}
	public void setUser_created_date(Timestamp createdDate) {
		this.user_created_date = createdDate;
	}
	public Timestamp getUser_update_date() {
		return user_update_date;
	}
	public void setUser_update_date(Timestamp user_update_date) {
		this.user_update_date = user_update_date;
	}

}
