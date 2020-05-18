package Java_Training.practice100.no220.no030;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class No030 implements Serializable {
	private static final long serialVersionUID = 1L;
	public String name;
	public int val;

public No030(String name, int val) {
	this.name = name;
	this.val = val;
}
	// public String getName() {
	// 	return name;
	// }

	// public int getNum() {
	// 	return val;
	// }
	
	// オブジェクトのシリアライズ
	public static void main(String[] args) {
		String outfile = "C://work//project//Kenshu//Systemi_Training_2020//Java_Training//practice100//no220//no030//No030.ser";

		No030 ser = new No030("Tom", 100);
		// System.out.println(ser.getName());
		// System.out.println(ser.getNum());
		System.out.println(ser.name);
		System.out.println(ser.val);

		try {
			var fileOutput = new FileOutputStream(outfile);
			var objOutput = new ObjectOutputStream(fileOutput);
			objOutput.writeObject(ser);
			objOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


