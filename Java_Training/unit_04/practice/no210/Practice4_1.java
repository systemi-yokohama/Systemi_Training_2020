package Java_Training.unit_04.practice.no210;

public class Practice4_1 {
	public static void main(String[] args) {
		for(var value : args) {
			var i = Integer.parseInt(value);
			System.out.println(i * 1.5);
		}
	}
}