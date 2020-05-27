package Java_Training.practice100.no213.no018;

public class No018 {
	public enum T_animal {
		NE(1, "子"), USHI(2, "丑"),
		TORA(3, "寅"), U(4, "卯"),
		TATSU(5, "辰"), MI(6, "巳"),
		UMA(7, "馬"), HITSUJI(8, "未"),
		SARU(9, "猿"), TORI(10, "酉"),
		INU(11, "戌"), I(12, "亥");

		private int id;
		private String animals;

		private T_animal(int id, String animals) {
			this.id = id;
			this.animals = animals;
		}
		public int getNumberId() {
			return this.id;
		}
		public String getName() {
			return this.animals;
		}
		public static T_animal getId(int id) {
			for(T_animal Tanimal : T_animal.values()) {
				if(Tanimal.getNumberId() == id) {
					return Tanimal;
				}
			}
			return null;
		}

		public static T_animal getAnimal(String animals) {
			for(T_animal tAnimal : T_animal.values()) {
				if(tAnimal.getName().equals(animals)) {
					return tAnimal;
				}
			}
			return null;
		}
	}
	public static void main(String[] args) {
		System.out.println(T_animal.getAnimal("子"));
		System.out.println(T_animal.getId(5));
	}
}