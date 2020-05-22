package Java_Training.practice100.no215;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class no030 implements Serializable {
	private static final long serialVersionUID=1L;
	public String s;
	public int i;

	public no030(String s,int i){
		this.s=s;
		this.i=i;
	}
	
	public static void main(String[] args) {
		final var file="C:/data/no030.ser";
		try (var out=new ObjectOutputStream(new FileOutputStream(file))){
			out.writeObject(new no030("シリアライズ",10));
			
			
		}catch(IOException e){
			e.printStackTrace();
		}

		try (var in=new ObjectInputStream(new FileInputStream(file))){
			var a=(no030)in.readObject();
			System.out.println(a);
		}catch(ClassNotFoundException | IOException e){
			e.printStackTrace();
		}
	}
}