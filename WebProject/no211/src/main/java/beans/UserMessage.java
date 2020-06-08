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

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return this.userId;
	}

	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}

	public void setCreated_Date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getCreated_Date() {
		return this.created_date;
	}
}