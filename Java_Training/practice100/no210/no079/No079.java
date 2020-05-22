package Java_Training.practice100.no210.no079;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.ArrayList;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

// ファイルの取得元のリストと保存先フォルダーを引数として受け取る
// 取得元にアクセスし、保存先フォルダーに対象ファイルを保存する
// 取得元としては、URL（http://example.com/folder/file.png の形式）、
// ローカルファイル（C:\temp\test.txtの形式）、UNC形式のパス(\\host\public\file.htmlの形式)の3種類が指定できる。
// 処理が失敗した場合は、保存先フォルダーのerror.txtに対して、失敗したファイルの取得元パスを出力する。

public class No079 {
	public static void main(String[] args) {
		
	}

	public void func(ArrayList<String>[] srcFile, String folder) {
		for(var file : srcFile) {
			try{
				var writer1 = Files.newBufferedWriter(Paths.get("error.txt"));
				var writer2 = Files.newBufferedWriter(Paths.get(folder));
				var reader = Files.newBufferedReader(Paths.get(file));

				if(file.toString().startsWith("http")) {
					var client = HttpClient.newHttpClient();
					var req = HttpRequest.newBuilder().uri(URI.create(file)).build();
					var res = client.send(req, HttpResponse.BodyHandlers.ofString());
					writer2.write(res.body());
				} else {
					writer2.write(reader);
				}

			} catch(IOException e) {
				writer1.write(file);
			}
		}		
	}
}