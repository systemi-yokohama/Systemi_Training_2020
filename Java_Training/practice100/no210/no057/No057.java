package Java_Training.practice100.no210.no057;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class No057 {
	public static void main(String[] args) {
		try(var reader = Files.newBufferedReader(Paths.get(args[0]), StandardCharsets.UTF_8)) {
			var line = "";
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			Files.copy(Paths.get(args[0]), Paths.get(args[0] + ".read"));
			Files.deleteIfExists(Paths.get(args[0]));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}