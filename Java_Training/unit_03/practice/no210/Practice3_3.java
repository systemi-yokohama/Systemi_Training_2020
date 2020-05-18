package Java_Training.unit_03.practice.no210;

public class Practice3_3 {
	public static void main(String[] args) {
		//nullが入っている変数に対してendsWithは使えない
		String str = null;
		if(str != null && str.endsWith(".java")) {
			System.out.println("拡張子は.javaです。");
		}
	}
}