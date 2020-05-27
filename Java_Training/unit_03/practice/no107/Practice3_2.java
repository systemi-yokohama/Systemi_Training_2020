package Java_Training.unit_03.practice.no107;

public class Practice3_2 {
	public static void main(String[] args) {
		String value = null;

		if (value == null) {
			System.out.println("値なし");
		} else {
			System.out.println(value);
		}

		var x = 6;
		var y = x;
		y -= 2;

		var builder1 = new StringBuilder("いろは");
		var builder2 = builder1;

		builder1.append("にほへと");

		System.out.println(x);
		System.out.println(y);

		System.out.println(builder1);
		System.out.println(builder2);

	}
}