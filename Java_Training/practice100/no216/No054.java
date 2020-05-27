/*1から100までの整数に含まれる偶数だけを加算した結果を求めるプログラムを
ストリームAPIを使用して実装せよ*/

package Java_Training.practice100.no216;
import java.util.stream.IntStream;

public class No054 {
	public static void main(String[] args) {
		System.out.println(
            IntStream.iterate(2, n -> n + 2)
                .takeWhile(n -> n <= 100)
                .sum()
        );
	}
}