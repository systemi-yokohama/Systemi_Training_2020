package Java_Training.practice100.no211;
import java.io.Serializable;

public class Article implements Serializable{
	private static final long serialVersionUID = 1L;
	public String str;
	public int i;

	public Article(String str, int i){
		this.str = str;
		this.i = i;
	}
}

//(No030)