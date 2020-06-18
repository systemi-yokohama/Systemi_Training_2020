package teamc.beans;

import java.util.Date;

public class UserManagement {
	private String account;
	private String name;
	private String password;
	private int id;
	private Date created_at;
	private String branches_name;
	private String departments_name;
	private int user_stop;
	private String stop_message;
	private int branches_id;
	private int departments_id;



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBranches_id() {
		return branches_id;
	}
	public void setBranches_id(int branches_id) {
		this.branches_id = branches_id;
	}
	public int getDepartments_id() {
		return departments_id;
	}
	public void setDepartments_id(int departments_id) {
		this.departments_id = departments_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStop_message() {
		return stop_message;
	}
	public void setStop_message(String stop_message) {
		this.stop_message = stop_message;
	}
	public int getUser_stop() {
		return user_stop;
	}
	public void setUser_stop(int user_stop) {
		this.user_stop = user_stop;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getBranches_name() {
		return branches_name;
	}
	public void setBranches_name(String branches_name) {
		this.branches_name = branches_name;
	}
	public String getDepartments_name() {
		return departments_name;
	}
	public void setDepartments_name(String departments_name) {
		this.departments_name = departments_name;
	}


}
