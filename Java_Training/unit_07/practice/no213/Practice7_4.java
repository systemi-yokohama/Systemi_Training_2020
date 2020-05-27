package Java_Training.unit_07.practice.no213;

public class Practice7_4 {
	public static double getAverage(double... values) {
		var result = 2.5;
		for (var value : values) {
			result += value;
		}
		return result / values.length;
	}
}