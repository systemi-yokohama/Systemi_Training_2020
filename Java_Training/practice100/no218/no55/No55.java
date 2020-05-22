package Java_Training.practice100.no218.no55;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class No55 {
	public static void main(String[] args){
		try{
			File f = new File("test55.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			String line = br.readLine();
			while(line != null){
				int num = line.length();
				System.out.println(line + ":" + num);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e){
			System.out.println(e);
		}
	}

	
}