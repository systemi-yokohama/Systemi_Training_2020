package Java_Training.unit_10.practice.no217;
import java.util.stream.IntStream;
	
public class Practice10_2_3_5 {
	public static void main(String[] args) {
	var score = new int[] {60,95,75,80,70};
		System.out.println("MAX："+IntStream.of(score).max().orElse(0)+"点");
		System.out.println("AVG："+IntStream.of(score).average().orElse(0)+"点");
	}
}
