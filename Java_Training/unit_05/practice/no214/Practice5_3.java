package Java_Training.unit_05.practice.no214;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.time.LocalDateTime;
public class Practice5_3 {
	public static void main(String[] args) {
	//コマンドライン引数の内容をカンマで連結した文字列をdata.datに書き出す。
	//data.datの文字コードはWindows-31J、複数回実行時は追記する。
	try(var writter=Files.newBufferedWriter(Paths.get("C:/data/data.dat"),Charset.forName("Windows-31J"))){
		writter.write(String.join(",",args));
	} catch(IOException e){
		e.printStackTrace();
	
	}
}
}