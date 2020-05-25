package Java_Training.practice100.no214;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.IOException;

/*java.nio 配下のパッケージのAPIを用いて、コマンドの第1引数に指定されたテキストファイル(UTF-8形式)が
BOM(Byte Order Mark)付きかどうかを判定し、
BOM付きであれば復帰値1、BOMなしであれば復帰値0で終わるプログラムを実装せよ。*/
public class No058 {
	public static void main(String[] args) {
	var data="C://data,txt";
	System.out.println(tex.charLenght(data));
	}
}
class tex{
	String data;
	public tex(String data){
		this.data=data;
	}
	public static int charLenght(String data){
	try (var in =new BufferedInputStream(
		new FileInputStream(data));
		var out =new BufferedOutputStream(new FileOutputStream(data))){
			int dataFin=-1;
			
			while((dataFin=in.read())!=-1){
			System.out.println(data);
			
			}
		}catch(NumberFormatException e){
			return 1;

		}catch(IOException e){
			e.printStackTrace();
		    return 0;
		}
	}
}

//NumberFormatExceptionエラーが出た際に1 がリターンする