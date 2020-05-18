package Java_Training.unit_05.practice.no210;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Practice5_2 {
	public static void main(String[] args) {
		var ptn = Pattern.compile(
			"[a-z0-9.!#$%&'*+/=?^_{|}~-]+@[a-z0-9]+(?:\\.[a-z0-9-]+)*",
			Pattern.CASE_INSENSITIVE
		);
		try(var reader = Files.newBufferedReader(Paths.get("C:/data/contact.txt"))) {
			var line = "";
			while((line = reader.readLine()) != null) {
				var match = ptn.matcher(line);
				while(match.find()) {
					System.out.println(match.group());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}