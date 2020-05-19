package Java_Training.practice100.no210.no023;

/*同一の名称で、int型1つを引数に取るメソッドとfloat型1つを引数に取るメソッドを作成し、
それぞれのメソッドでは渡された引数を文字列に変換して返すように実装せよ。*/

public class No023 {
	public static void main(String[] args) {

	}

	public static String change(int intnum) {
		return Integer.toString(intnum);
	}

	public static String change(float floatnum) {
		return Float.toString(floatnum);
	}
}