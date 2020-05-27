package Java_Training.practice100.no213.no055;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class No055 {
	public static void main(String[] args) {
		try(var reader = Files.newBufferedReader(Paths.get("C:\\work\\project\\UTF-8.txt"))) {
			var sum = "";
			while((sum = reader.readLine()) != null) {
				System.out.println(sum);
				System.out.println(sum.length());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}