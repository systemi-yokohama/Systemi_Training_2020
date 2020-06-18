package teamc.beans;

import java.util.Date;

public class Comments {
	private int id;
	private String text;
	private int user_id;
	private int tweets_id;
	private Date created_at;
	private Date updated_at;
	private Users user;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTweets_id() {
		return tweets_id;
	}
	public void setTweets_id(int tweets_id) {
		this.tweets_id = tweets_id;
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

	public Users getUser(){
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
}
