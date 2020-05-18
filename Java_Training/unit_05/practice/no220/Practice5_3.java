package Java_Training.unit_05.practice.no220;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;


public class Practice5_3 {
	public static void main(String[] args) {

		try {
			var writer = Files.newBufferedWriter(
			Paths.get("C://work//project//Kenshu//Systemi_Training_2020//test.txt"),
			Charset.forName("Windows-31J"),
			StandardOpenOption.APPEND);
			
				String str = "helloworld";
				writer.write(str);
				writer.newLine();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}
	