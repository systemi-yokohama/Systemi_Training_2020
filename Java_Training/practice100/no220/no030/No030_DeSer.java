package Java_Training.practice100.no220.no030;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class No030_DeSer {
	public static void main(String[] args) {
		String infile = "C://work//project//Kenshu//Systemi_Training_2020//Java_Training//practice100//no220//no030//No030.ser";

		try {
			var fileInput = new FileInputStream(infile);
			var objInput = new ObjectInputStream(fileInput);
			// ファイルからJavaオブジェクトに出力
			var deser = (No030)objInput.readObject();
			objInput.close();
			System.out.println(deser);

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}