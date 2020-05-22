package Java_Training.practice100.no210.no059;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class No059 {
	public static void main(String[] args) {

		
		try(var writer1 = Files.newBufferedWriter(Paths.get("header.txt"));
			var writer2 = Files.newBufferedWriter(Paths.get("body.txt"))) {

			var client = HttpClient.newHttpClient();
			var req = HttpRequest.newBuilder().uri(URI.create(args[0])).build();
		
			var res = client.send(req, HttpResponse.BodyHandlers.ofString());

			writer1.write(res.headers().toString());
			writer2.write(res.body());
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(InterruptedException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}