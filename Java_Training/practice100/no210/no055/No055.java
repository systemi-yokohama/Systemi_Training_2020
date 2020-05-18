package Java_Training.practice100.no210.no055;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class No055 {
	public static void main(String[] args) {
		try(var reader = Files.newBufferedReader(Paths.get("data.txt"), StandardCharsets.UTF_8)) {
			var line = "";
			var letterCount = 0;
			while((line = reader.readLine()) != null) {
				letterCount += line.length();
			}
			System.out.println("合計文字数は" + letterCount + "です。");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}