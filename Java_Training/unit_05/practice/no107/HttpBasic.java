package Java_Training.unit_05.practice.no107;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpBasic {
	public static void main(String[] args) throws IOException, InterruptedException {

		// HTTPクライアント生成
		var client = HttpClient.newHttpClient();

		// リクエスト準備
		var req = HttpRequest.newBuilder().uri(URI.create("https://codezine.jp/")).build();

		// レスポンス準備
		var res = client.send(req, HttpResponse.BodyHandlers.ofString());

		// 取得したコンテンツを取得
		System.out.println(res.body());

	}
}