package Java_Training.unit_05.practice.no219;

public class Practice5_2_2 {
	public static void main(String[] args) {
	var str="お問い合わせはsupport@example.comまで";
	System.out.println(str.replaceAll("\\w+@\\w+(?:\\.\\w+)*","<a href=\"mailto:$0\">$0</a>"));
	}
}	