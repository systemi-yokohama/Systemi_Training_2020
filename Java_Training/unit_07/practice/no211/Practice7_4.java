package Java_Training.unit_07.practice.no211;

public class Practice7_4 {
	public static double getAverage(int... values) {
		var sum = 0;
		var count = 0;

		for(var value : values){
			sum += value;
			count += 1;
		}
		return sum/count;
	}

	public static void main(String[] args) {
		System.out.println(Practice7_4.getAverage(1, 2, 3, 5, 7, 11));
	}
}