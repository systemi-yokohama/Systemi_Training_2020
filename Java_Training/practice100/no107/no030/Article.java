package Java_Training.practice100.no107.no030;

import java.io.Serializable;

public class Article implements Serializable {

	private static final long seriaVersionUID = 1L;

	public String title = "????";
	public int page = 30;

	public Article(String title, int page) {
		this.title = title;
		this.page = page;
	}

}