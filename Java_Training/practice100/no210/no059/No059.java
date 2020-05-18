package Java_Training.practice100.no210.no059;
import java.net.HttpURLConnection;
import java.net.http.HttpRequest;
import java.net.URL;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class No059 {
	public static void main(String[] args) {
		var connection = (HttpURLConnection) new URL(args[0]).openConnection();
		var result = connection.getResponseCode();
		if(result != 200) {
			System.out.println(0);
		}
		System.out.println(result);

		try(var writer1 = Files.newBufferedWriter(Paths.get("header.txt"));
			var writer2 = Files.newBufferedWriter(Paths.get("body.txt"))) {
			writer1.write(connection.headers());
			writer2.write(connection.body());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}