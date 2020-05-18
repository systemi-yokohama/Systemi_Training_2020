package Java_Training.practice100.no214;
//UTF-8のテキストファイルを読み込み、
//各行の文字数の合計を出力するプログラムを実装せよ。ラインセパレタはカウントしない。

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class No055 {
	
public void mein(String[] args){
	final var file="C:\data\data.txt";
	try (var reader = Files.newBufferedReader(
		Paths.get("C:\data\data.txt"),"UTF-8")){
			String str = reader.readLine();
			while(str != null){ 
			 
			  System.out.println(str);
			  System.out .println(str.length());
			  str = reader.readLine();
		}
	} catch (IOException e) {
		e.printStackTrace();		
	}
}
}
	

