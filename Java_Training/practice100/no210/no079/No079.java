package Java_Training.practice100.no210.no079;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;

/* ファイルの取得元のリストと保存先フォルダーを引数として受け取る
 取得元にアクセスし、保存先フォルダーに対象ファイルを保存する
 取得元としては、URL（http://example.com/folder/file.png の形式）、
 ローカルファイル（C:\temp\test.txtの形式）、UNC形式のパス(\\host\public\file.htmlの形式)の3種類が指定できる。
 処理が失敗した場合は、保存先フォルダーのerror.txtに対して、失敗したファイルの取得元パスを出力する。*/

public class No079 {
	
	public void func(ArrayList<String>[] srcFile, String folder) throws IOException {
		for(var file : srcFile) {

			var wError = Files.newBufferedWriter(Paths.get("wrror.txt"));
			var wSuccess = Files.newBufferedWriter(Paths.get(folder));
			var reader = Files.newBufferedReader(Paths.get(file.toString()));

			try{
				
				var line = "";
				while((line = reader.readLine()) != null) {
					wSuccess.write(line);
				}

			} catch(IOException e) {
				wError.write(file.toString());
			} 
		}
	}
}