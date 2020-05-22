package Java_Training.unit_10.practice.no211;
import java.util.stream.IntStream;

public class Check10_3_5 {
	public static void main(String[] args) {
		var list = new int[] {60, 95, 75, 80, 70};
		System.out.println(IntStream.of(list).max().orElse(0));
		System.out.println(IntStream.of(list).average().orElse(0));
	}		
}

//→〇