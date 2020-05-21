package Java_Training.practice100.no210.no018;

public enum Zodiac {
	RAT(1, "子"),
	OX(2, "丑"),
	TIGER(3, "寅"),
	RABBIT(4, "卯"),
	DRAGON(5, "辰"),
	SNAKE(6, "巳"),
	HORSE(7, "午"),
	SHEEP(8, "未"),
	MONKEY(9, "申"),
	ROOSTER(10, "酉"),
	DOG(11, "戌"),
	PIG(12, "亥");

	private int id;
	private String zoName;

	private Zodiac(int id, String zoName) {
		this.id = id;
		this.zoName = zoName;
	}

	public int getId() {
		return this.id;
	}

	public String getZoName() {
		return this.zoName;
	}

	public static Zodiac findName(int id) {
		for(var animal : Zodiac.values()) {
			if(animal.id == (id)) {
				return animal;
			}
		}
		return null;
	}

	public static Zodiac findId(String zoName) {
		for(var animal : Zodiac.values()) {
			if(animal.zoName.equals(zoName)) {
				return animal;
			}
		}
		return null;
	}
}