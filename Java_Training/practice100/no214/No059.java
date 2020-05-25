package Java_Training.practice100.no214;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/*コマンドの第1引数に指定されたhttpプロトコルのURLにアクセスし、
レスポンスコードを標準出力、レスポンスヘッダを header.txt 
、レスポンスボディを body.txt にそれぞれ出力するプログラムを実装せよ。
URLへのアクセスに失敗した場合は復帰値1で終了し、標準エラー出力に失敗内容を出力するものとする。 */

class No059{
public static void main(String[] args){
	var client =HttpClient.newHttpClient();
	var req=HttpRequest.newBuilder()
	.uri(URI.create("http://no214.jp/"))
	.build();

	var res=client.send(req, HttpResponse.BodyHandlers.toString());
	
	
	try (var in =new BufferedInputStream(new FileInputStream("header.txt"));
		 var out =BufferedOutputStream(new FileOutputStream("http://no214.jp/"))){

		var data=-1;
		while((data=in.read())!=-1){
		
			out.write((byte)data);
		}
	}catch(URISyntaxException e){
		
		System.out.println("ファイルにアクセスできません");
	} 
	finally {
		System.out.println("------------------------------");
	}

}}