package Java_Training.practice100.no217;
import java.util.stream.IntStream;

public class No054 {
	public static void main(final String[] args) {
        System.out.println(IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0).sum());
    }
}