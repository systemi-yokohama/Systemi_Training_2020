package Java_Training.practice100.no216;
import java.io.*;

public class No030_2 {
	public static void main(String[] args) throws Exception{
		No030_1 test1 = new No030_1("test1", 1);

		FileOutputStream fos = new FileOutputStream("C:");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(test1);
		oos.flush();
		oos.close();

		FileInputStream fis = new FileInputStream("C:");
		ObjectInputStream ois = new ObjectInputStream(fis);
		No030_1 test2 = (No030_1) ois.readObject();
		ois.close();

		System.out.println(test2);
	}
}