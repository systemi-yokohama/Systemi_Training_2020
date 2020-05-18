package Java_Training.practice100.no220.no037;
import java.util.Arrays;

public class No037 {
	public static void main(String[] args) {

		var array1 = new StringBuilder[] {
			new StringBuilder("ドレミファソ"),
			new StringBuilder("CDEFG"),
			new StringBuilder("イロハニ"),
		};
		
		// シャローコピー
		var array2 = Arrays.copyOf(array1, array1.length);
		array1[2].append("ホヘト");
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		
		// ディープコピー
		var array3 = new StringBuilder[array1.length];
		for(var i = 0; i < array1.length; i++) {
			array3[i] = new StringBuilder(array1[i].toString());
		}

		array1[2].append("ホヘト");
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array3));


    }
}