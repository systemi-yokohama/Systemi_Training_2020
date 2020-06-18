package teamc.beans;

import java.util.Date;

public class Users {
	private int id;
	private String account;
	private String password;
	private String name;
	private int user_stop;
	private int branches_id;
	private int departments_id;
	private Date created_at;
	private Date updated_at;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getUser_stop() {
		return user_stop;
	}
	public void setUser_stop(int user_stop) {
		this.user_stop = user_stop;
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

	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}
