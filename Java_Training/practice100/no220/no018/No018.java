package Java_Training.practice100.no220.no018;

public class No018 {

	public enum Type {
		ne(1, "子"),
		usi(2, "丑"),
		tora(3, "寅"),
		u(4, "卯"),
		tatsu(5, "辰"),
		mi(6, "巳"),
		uma(7, "午"),
		hitsuji(8, "未"),
		saru(9, "申"),
		tori(10, "酉"),
		inu(11, "戌"),
		i(12, "亥");

		public int id;
		public String name;

		private Type(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int toTypeValue() {
			return this.id;
		}

		public String toString() {
			return this.name;
		}

	}
			public static void main(String[] args) {
				System.out.println(Type.ne);
				System.out.println(Type.ne.toTypeValue());
				System.out.println(Type.ne.toString());
			}
}