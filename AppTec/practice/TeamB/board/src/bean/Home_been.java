package bean;

public class Home_been {
	String user_name;
	String write_category;
	String write_subject;
	String write_text;
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
}
