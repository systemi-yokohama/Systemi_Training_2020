package Java_Training.unit_06.practice.no220;
import java.util.ArrayList;
import java.util.Arrays;

public class Practice6_3 {
	public static void main(String[] args) {
		var list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
		list.add(100);
		list.set(2, 30);
		list.remove(3);
		for(var i : list) {
			System.out.println(i);
		}		

}
}