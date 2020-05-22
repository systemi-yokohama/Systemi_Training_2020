package Java_Training.practice100.no220.no055;import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class No055 {
	public static void main(String[] args) {
		File file = new File("C://work//project//Kenshu//Systemi_Training_2020//Java_Training//practice100//no220//no055//No055.txt");
		
		try {
			// 指定したファイルをバイナリとして読み込む
			FileInputStream fileinput = new FileInputStream(file);
			// 指定した文字コードで構成されるテキストファイルを読み込む
			InputStreamReader inputstream = new InputStreamReader(fileinput, "UTF-8");
			// ファイルを一行ずつ読み込む
			BufferedReader b_reader = new BufferedReader(inputstream);
			String line = b_reader.readLine();
			
			while(line != null) {
				System.out.println(line);
				System.out.println(line.length());
				line = b_reader.readLine();
			}
				b_reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}