package Java_Training.practice100.no210.no054;
import java.util.stream.IntStream;

public class No054 {
	public static void main(String args[]) {

		System.out.println(IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).sum());
		
	}
}
