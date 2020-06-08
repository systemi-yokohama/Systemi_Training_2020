package beans;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int id;
    private String account;
    private String name;
    private String email;
    private String password;
    private String description;
    private Date createdDate;
    private Date updatedDate;

	// getter/setterは省略されているので、自分で記述しましょう。
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return this.account;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getUpdatedDate() {
		return this.updatedDate;
	}
}