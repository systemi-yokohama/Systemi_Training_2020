package Java_Training.practice100.no210.no058;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class No058 {
	public static void main(String[] args) {
		try(var reader = Files.newBufferedReader(Paths.get(args[0]), StandardCharsets.UTF_8)) {
			byte[] byt = Files.readAllBytes(Paths.get(args[0]));
			if(byt[0] == 0xEF && byt[1] == 0xBB && byt[2] == 0xBF) {
				System.exit(0);
			} else {
				System.exit(1);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}