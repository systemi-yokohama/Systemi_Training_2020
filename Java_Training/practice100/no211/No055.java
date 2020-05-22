package Java_Training.practice100.no211;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//import java.nio.file.Files;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class No055 {
	public static void main(String[] args) {
		try(var reader = new BufferedReader(
			new InputStreamReader(
				new FileInputStream("C:/work/project/Kenshu/Systemi_Training_2020/Java_Training/practice100/no211/Article.md"),
				"UTF-8"))){
					/*
					var line = "";
					while((line = reader.readLine()) != null){
						System.out.println(line);
					}	
					*/

					
					//→文字数をカウントする!!!
					/* 文字数の合計. */
					AtomicInteger sum = new AtomicInteger(0);
            
					// 一行毎の文字数を取得し、{@code sum}に足していく.
					reader.lines().parallel().forEach(line -> sum.addAndGet(line.length()));
					
					// 文字数をカウントし、標準出力する.
					System.out.println(sum + "文字");
		

				}catch(IOException e){
					e.printStackTrace();
				}
	}
}