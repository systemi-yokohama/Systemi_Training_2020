package Java_Training.unit_05.practice.no217;

public class Practice5_4_2 {
	public static void main(String[] args){
		var a = "千葉";
		var b = 17.256;

		String c = String.format("%sの気温は%.2f℃です。",a,b);
		System.out.println(c);
	}
}