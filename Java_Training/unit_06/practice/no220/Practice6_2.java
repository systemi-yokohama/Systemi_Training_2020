package Java_Training.unit_06.practice.no220;
import java.util.HashMap;

public class Practice6_2 {
	public static void main(String[] args) {
		var map = new HashMap<String, String>() {
		{
			put("cucumber", "キュウリ");
			put("lettuce", "レタス");
			put("spinach", "ホウレンソウ");
		}		
	};

	map.put("carrot", "にんじん");
	map.remove("spinach");
	map.replace("cucumber", "胡瓜");

	for(var entry : map.entrySet()) {
		System.out.println(entry.getKey() + ":" + entry.getValue());
	}
}
}