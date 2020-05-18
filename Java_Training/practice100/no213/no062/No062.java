package Java_Training.practice100.no213.no062;

import java.util.HashMap;
import java.util.Map;

public class No062 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(100);
		map.put("key13", "value4");
		map.put("key86", "value2");
		map.put("key133", "value1");

		System.out.println(map.get("key103"));
		map.put("key13", "value70");
		System.out.println(map.get("key13"));
		System.out.println(map.get("key103"));

		assert map.size() == 100;
		if(map.size() == 100) {
			map.clear();
		} else {
			//データ残る
		}

	}
}