package Java_Training.practice100.no220.no059;
import java.net.http.*;
import java.net.URI;

public class No059 {

	public static void main(String[] args) {
		// HTTPクライアントを生成
		HttpClient client = HttpClient.newBuilder()
		.version(HttpClient.Version.HTTP_2)
		.build();
		
		// リクエストを準備
		HttpRequest req = HttpRequest.newBuilder()
		.uri(URI.create("https://codezine.jp/"))
		.header("Content-Type","application/json")
		.POST(HttpRequest.BodyPublishers.ofString(""))
		.build();

		// リクエストを送信
		client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
		.thenAccept(res ->{
			System.out.println(res.body());
		});

	}
}