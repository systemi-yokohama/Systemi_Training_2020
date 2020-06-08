package beans;

import java.io.Serializable;
import java.util.Date;

public class UserMessage implements Serializable {

    private int id;
    private String account;
    private String name;
    private int userId;
    private String text;
    private Date created_date;

	// getter/setterは省略されているので、自分で記述しましょう。
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getCreated_date() {
		return this.created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

}