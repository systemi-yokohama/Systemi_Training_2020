package Java_Training.practice100.no214;

import java.lang.module.ModuleDescriptor.Requires;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.FileSystems;

/*コマンドの第1引数に指定されたhttpプロトコルのURLにアクセスし、
レスポンスコードを標準出力、レスポンスヘッダを header.txt 
、レスポンスボディを body.txt にそれぞれ出力するプログラムを実装せよ。
URLへのアクセスに失敗した場合は復帰値1で終了し、標準エラー出力に失敗内容を出力するものとする。 */
public class No059 {
	public void main(String[] args){
	
		Requires java.net.http;
		var client=HttpClient.newHttpClient();
		var req=HttpRequest.newBuilder()
		.url(URL.create("https://sample.jp"))
		.build;


//レス

		var res =client.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(res.header());
		System.out.println(res.body());
	 
	
	}
}