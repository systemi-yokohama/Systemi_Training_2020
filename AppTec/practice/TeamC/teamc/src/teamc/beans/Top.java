package teamc.beans;

import java.util.Date;
import java.util.List;

public class Top {
	private int tweet_id;
	private String subject;
	private String text;
	private String category;
	private Users user;
	private Date created_at;
	private Date updated_at;
	private List<Comments> comment = null;
	private String comment_name;


	public int getTweet_id() {
		return tweet_id;
	}
	public void setTweet_id(int tweet_id) {
		this.tweet_id = tweet_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	public List<Comments> getComment() {
		return comment;
	}
	public void setComment(List<Comments> comment) {
		this.comment = comment;
	}

	public String getComment_name() {
		return comment_name;
	}
	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}

}
