package Java_Training.unit_07.practice.no211;

public class Practice7_3 {

	public static double getBmi(double weight, double height){
		return Math.round(weight/Math.pow(height, 2));
	}
	

	public static void main(String[] args) {
		System.out.println(Practice7_3.getBmi(50, 1.6));
	}
}

//→〇