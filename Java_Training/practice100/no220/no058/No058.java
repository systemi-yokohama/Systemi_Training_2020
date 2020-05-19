package Java_Training.practice100.no220.no058;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class No058 {
	public static void main(String[] args) {

		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;

		try {
			fos = new FileOutputStream("C:\\work\\project\\Kenshu\\Systemi_Training_2020\\No058.txt");

			fos.write(0xef);
			fos.write(0xbb);
			fos.write(0xbf);

			osw = new OutputStreamWriter(fos, "UTF-8");
			bw = new BufferedWriter(osw);

			bw.write("Hello");

			bw.flush();
			osw.flush();
			fos.flush();
			bw.close();
			osw.close();
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}