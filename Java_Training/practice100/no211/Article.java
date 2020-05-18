package Java_Training.practice100.no211;
import java.io.Serializable;

public class Article implements Serializable{
	private static final long serialVersionUID = 1L;
	public String title;
	public String url;
	public transient boolean expired;

	public Article(String title, String url, boolean expired){
		this.title = title;
		this.url = url;
		this.expired = expired;
	}
}