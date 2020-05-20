package Java_Training.unit_07.practice.no219;

public class Practice7_4 {
	public static double getAverage(double... values) {
		var result =0.0;
		for (var value:values){
			result+=value;
		}
		return result/values.length;
	}
}