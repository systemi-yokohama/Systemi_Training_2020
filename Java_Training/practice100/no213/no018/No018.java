package Java_Training.practice100.no213.no018;

import java.util.UUID;

public class No018 {
	private int id;
	private String animals;

	private No018(int id, String animals) {
		this.id = id;
		this.animals = animals;
	}

	public int ids() {
		return this.id;
	}
	public String animalss() {
		return this.animals;
	}
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		var all = T_animal.values();
		System.out.println(uuid.toString());
		System.out.println(all);
	}
	public enum T_animal {
		NE(uuid, "子"), USHI(uuid, "丑"),
		TORA(uuid, "寅"), U(uuid, "卯"),
		TATSU(uuid, "辰"), MI(uuid, "巳"),
		UMA(uuid, "馬"), HITSUJI(uuid, "未"),
		SARU(uuid, "猿"), TORI(uuid, "酉"),
		INU(uuid, "戌"), I(uuid, "亥");
	}
}