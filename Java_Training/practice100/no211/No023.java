package Java_Training.practice100.no211;

public class No023 {
	public static String overload(int n){
		return String.valueOf(n);
	}
	public static String overload(float n){
		return String.valueOf(n);
	}

	public static void main(String[] args) {
		System.out.println(overload(30));
	}
}

//→〇引数の部分にはfinalを入れたほうが良い