/*
[1]
(int i) -> {
	return i * i;
}

i -> i * i;

→〇

*/


//[2]
package Java_Training.unit_10.practice.no211;
import java.util.ArrayList;
import java.util.Arrays;

public class Practice10_1 {
	public static void main(String[] args) {

		var data = new ArrayList<String>(
			Arrays.asList("あいう", "かきくけこかき", "さしすせそ"));
		
		data.removeIf(v -> v.length() < 5);
		System.out.println(data);
	}
}

//→〇