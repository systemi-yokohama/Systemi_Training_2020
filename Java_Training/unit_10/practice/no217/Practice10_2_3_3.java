package Java_Training.unit_10.practice.no217;
import java.util.ArrayList;
	
public class Practice10_2_3_3 {
	public static void main(String[] args) {
	ArrayList<String> text = new ArrayList<String>();
	
	text.add("ABCDE");
	text.add("OP");
	text.add("WXYZ");
	text.add("HIJKL");

	System.out.println(text);
	
	text.replaceAll(v -> {
		if(v.length() < 3) {
			return v;
		} else {
			return v.substring(0,3);
		}
	});
	System.out.println(text);	
	}
}
