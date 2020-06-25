package bean;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	int user_id;
	String user_account;
	String user_password;
	String user_name;
	String user_office;
	String user_department;
	String user_status;
	Date user_created_date;
	Date user_updated_date;
	String check_user_password;

	String office_id;
	String office_name;

	String department_id;
	String department_name;

	int write_user_id;
	int comment_user_id;

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

	public Date getUser_created_date() {
		return user_created_date;
	}

	public void setUser_created_date(Date user_created_date) {
		this.user_created_date = user_created_date;
	}

	public Date getUser_updated_date() {
		return user_updated_date;
	}

	public void setUser_updated_date(Date user_updated_date) {
		this.user_updated_date = user_updated_date;
	}

	public String getOffice_id() {
		return office_id;
	}

	public void setOffice_id(String office_id) {
		this.office_id = office_id;
	}

	public String getOffice_name() {
		return office_name;
	}

	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String departments_id) {
		this.department_id = departments_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String departments_name) {
		this.department_name = departments_name;
	}

	public String getCheck_user_password() {
		return check_user_password;
	}

	public void setCheck_user_password(String check_user_password) {
		this.check_user_password = check_user_password;
	}

	public int getWrite_user_id() {
		return write_user_id;
	}

	public void setWrite_user_id(int write_user_id) {
		this.write_user_id = write_user_id;
	}

	public int getComment_user_id() {
		return comment_user_id;
	}

	public void setComment_user_id(int comment_user_id) {
		this.comment_user_id = comment_user_id;
	}

}
