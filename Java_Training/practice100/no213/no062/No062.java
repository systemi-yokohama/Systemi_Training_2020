package Java_Training.practice100.no213.no062;

import java.util.Collections;
import java.util.Map;

import Java_Training.practice100.no211.LruHashMap;

public class No062 {
	public static void main(String[] args) {
		Map<String, String> map = Collections.synchronizedMap(new LruHashMap<>(100));
		map.put("key13", "value4");
		map.put("key86", "value2");
		map.put("key133", "value1");

		System.out.println(map.get("key103"));
		map.put("key13", "value70");
		System.out.println(map.get("key13"));
		System.out.println(map.get("key103"));
		MapSave(map);
		DeleteData(map);
	}

	public static void MapSave(Map<String, String> map) {
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue() + "\n");
		}
	}

	public static void DeleteData(Map<String, String> map) {
		for(int i = 0; i < 100; i++) {
			map.put("key" + i, "value" + i);
			if(map.size() == 100) {
				map.clear();
			}
		}
	}
}