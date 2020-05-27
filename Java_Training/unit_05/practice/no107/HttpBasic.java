package Java_Training.unit_05.practice.no107;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpBasic {
	public static void main(String[] args) throws IOException, InterruptedException {

		// HTTPクライアント生成
		var client = HttpClient.newHttpClient();

		// リクエスト準備
		var req = HttpRequest.newBuilder().uri(URI.create("https://www.google.co.jp/")).build();

		// レスポンス準備
		var res = client.send(req, HttpResponse.BodyHandlers.ofString());

		// 取得したコンテンツを取得
		// System.out.println(res.headers());
		// System.out.println(res.body());

		// 取得した情報をテキストファイルに出力

		String headerPath = "C:\\work\\project\\Kenshu\\Systemi_Training_2020\\Java_Training\\practice100\\no107\\no059\\header.txt";
		String bodyPath = "C:\\work\\project\\Kenshu\\Systemi_Training_2020\\Java_Training\\practice100\\no107\\no059\\body.txt";

		try {
			var headerWriter = Files.newBufferedWriter(Paths.get(headerPath));
			headerWriter.write(res.headers().toString());
			headerWriter.newLine();
			headerWriter.close();

			var bodyWriter = Files.newBufferedWriter(Paths.get(bodyPath));
			bodyWriter.write(res.headers().toString());
			bodyWriter.newLine();
			bodyWriter.close();

		} catch (Exception e) {

		}

	}
}