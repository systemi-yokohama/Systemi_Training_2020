package Java_Training.practice100.no214;
/*以下の要件を満たすクラスを作成するよう、リーダーから指示された。簡単に設計ポリシーを説明した上で、該当クラスを実装せよ。
＜要件＞
ファイルの取得元のリストと保存先フォルダーを引数として受け取る
取得元にアクセスし、保存先フォルダーに対象ファイルを保存する
取得元としては、URL（http://example.com/folder/file.png の形式）、ローカルファイル（C:\temp\test.txtの形式）、UNC形式のパス(\\host\public\file.htmlの形式)の3種類が指定できる。
処理が失敗した場合は、保存先フォルダーのerror.txtに対して、失敗したファイルの取得元パスを出力する。*/
import java.io.ObjectInput;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.*;

public class No079 {
	public static void main(String[] args) {
		var fs =FileSystems.getDefault();

		var path=fs.getPath("http://example.com/folder/file.png");	
		
	

		try (var out =Files.newBufferedReader(path.get(dir1))){
		out.writeObject(new data("C:\temp\test.txt"),false);
        } catch (IOException e) {
			System.out.println(fs);
	      e.printStackTrace();
}
	}


}