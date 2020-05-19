package Java_Training.practice100.no220.no059;
import java.net.http.*;

public class No059 {
	public static void main(String[] args) {
		var client = HttpClient.newHttpClient();
		var req = HttpRequest.newBuilder()
		.uri(URI.create("https://codezine.jp/"))
		.build();

		var res =client.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(res.body());
	}
}