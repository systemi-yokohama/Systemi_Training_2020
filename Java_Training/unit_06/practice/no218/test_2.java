package Java_Training.unit_06.practice.no218;

import java.util.HashMap;

public class test_2 {
	public static void main(final String[] args){
		final var map = new HashMap<String, String>(){
		    {
				put("cucmber", "きゅうり");
			put("lerruce","レタス");
			put("spinach","ホウレンソウ");

			}
		};

		map.put("carrot","ニンジン");
		map.remove("spinach");
		map.replace("cucumber", "胡瓜");

		for(final var entry : map.entrySet()){
			System.out.println(entry.getKey()+ ":" + entry.getValue());
		}
	}
	
}