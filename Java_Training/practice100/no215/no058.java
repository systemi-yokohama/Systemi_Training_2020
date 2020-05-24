package Java_Training.practice100.no215;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/* BOMとは「Byte Order Mark(バイトオーダーマーク)」の略で、
「このファイルは Unicode 形式で書かれています」と判別させるための情報。
３バイトのコード（0xEF 0xBB 0xBF）を ファイルの先頭に付けることがあり、これがBOM付きUTF-8ファイル*/
/*System.exit(0);→実行中のjava仮想マシンを終了する*/

public class no058 {
	public static void main(String[] args){
		try(var reader=Files.newBufferedReader(Paths.get(args[0]))){
			byte[] byte1 = Files.readAllBytes(Paths.get(args[0]));
			if(byte1[0]==(byte)0xEF && byte1[1]==(byte)0xBB && byte1[2]==(byte)0xBF){
				System.out.println("BOM付きファイル");
				System.exit(1);
			}else{
				System.exit(0);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
			
		
	}
}