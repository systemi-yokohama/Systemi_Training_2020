package Java_Training.unit_05.practice.no216;

public class Practice5_3 {
	public static void main(String[] args) {

		for(String s : args) {
		var result1 = s.split(",");
		System.out.println(String.join(" ", result1));
		}
	}
}