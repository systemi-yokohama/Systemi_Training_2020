package Java_Training.practice100.no213.no055;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class No055 {
	public static void main(String[] args) {
		try(var reader = Files.newBufferedReader(Paths.get("UTF8.txt"))) {
			var sum = reader.readLine();
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}