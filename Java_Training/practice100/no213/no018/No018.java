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
		public int NumberId() {
			return this.id;
		}
		public String Name() {
			return this.animals;
		}
	}
}