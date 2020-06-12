package beans;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int userId;
    private String text;
    private Date createdDate;
    private Date updatedDate;

	// getter/setterは省略されているので、自分で記述しましょう。
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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

	public Date getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}