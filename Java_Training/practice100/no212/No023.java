/*
 オーバーロード
 ・同一の名称で、int型１つを引数にとるメソッドとfloat型１つを引数にとるメソッドを作成し、
 それぞれのメソッドでは渡された引数を文字列に変換して返すように実装
*/
package Java_Training.practice100.no212;

public class No023{
	
	public static String one(int a){
	return String.valueOf(a);
	}

	public static String one(float b){
    return String.valueOf(b);
	}

}
