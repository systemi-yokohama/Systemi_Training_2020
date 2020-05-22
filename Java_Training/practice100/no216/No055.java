package Java_Training.practice100.no216;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class No055 {
	public static void main(String[] args) {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("No055.txt"))) {
			AtomicInteger sum = new AtomicInteger(0);

			reader.lines().parallel().forEach(line -> sum.addAndGet(line.length()));

			System.out.println(sum + "文字");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
