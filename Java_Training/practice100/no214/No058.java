package Java_Training.practice100.no214;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.IOException;

/*java.nio 配下のパッケージのAPIを用いて、コマンドの第1引数に指定されたテキストファイル(UTF-8形式)が
BOM(Byte Order Mark)付きかどうかを判定し、
BOM付きであれば復帰値1、BOMなしであれば復帰値0で終わるプログラムを実装せよ。*/
public class No058 {
	public static void main(String[] args) {
	}
	public int charLenght(String data,int list){
	try (var in =new BufferedInputStream(
		new FileInputStream(data));
		var out =new BufferedOutputStream(new FileOutputStream(data))){
			var dataFin=-1;
			var line=" ";
			while((dataFin=in.read())!=-1){
			System.out.println(data);
			}
		}catch(NumberFormatException e){
			return 1;
		}finally{
			return 0;
		}
	}
}

//NumberFormatExceptionエラーが出た際に1 がリターンする