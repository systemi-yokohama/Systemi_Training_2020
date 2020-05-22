package Java_Training.unit_10.practice.no211;
import java.util.Arrays;
import java.util.ArrayList;

public class Check10_3_3 {
	public static void main(String[] args) {
		var data = new ArrayList<String>(
			Arrays.asList("ABCDE", "OP", "WXYZ", "HIJKL"));

		data.replaceAll(v -> {
			if(v.length() < 3){
				return v;
			}
			else{
				return v.substring(0, 3);
			}
		});

		System.out.println(data);
	}
}

//→〇