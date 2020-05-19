package Java_Training.practice100.no216;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import  java.io.ObjectInputStream;


public class No030 {
	public static void main(String[] args) {
		final var file = C:/data;

		public class Article implements Serializable {
			private static final long serialVersionUID = 1L;
			public String title;
			public int no;

			public Article(String title, int no) {
				this.title = title;
				this.no = no;
			}
		}

		try ( var out = new ObjectOutputStream( new FileOutputStream(file))) {
			out.writeObject( new Article("シリアライズ",030));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try ( var in = new ObjectInputStream( new FileInputStream(file))) {
			var a = (Article)in.readObject();
			System.out.println(a);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
} 