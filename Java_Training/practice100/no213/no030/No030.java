package Java_Training.practice100.no213.no030;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class No030 implements Serializable {
	private static final long serialVersionUID = 1L;
	public String title;
	public String url;
	public int i;

	public No030(String title, String url, int i) {
		this.title = title;
		this.url = url;
		this.i = i;
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file1.txt"))){
			out.writeObject(new No030(title, url, i));
		} catch(IOException s) {
			s.printStackTrace();
		}	

		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"))) {
			var aa = (No030)in.readObject();
			System.out.println(aa);
		} catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}