package Java_Training.practice100.no217;

public class No018 {
	// 十二支
	private enum Zodiac {
		RAT(1,"rat"),
		OX(2,"ox"),
		TIGER(3,"tiger"),
		RABBIT(4,"rabbit"),
		DRAGON(5,"dragon"),
		SNAKE(6,"snake"),
		HORSE(7,"horse"),
		SHEEP(8,"sheep"),
		MONKEY(9,"monkey"),
		ROOSTER(10,"rooster"),
		DOG(11,"dog"),
		BOAR(12,"boar");
		
		// 十二支のid,名称
		private int id;
		private String label;
		Zodiac(int id, String label) {
			this.id = id;
			this.label = label;
		}

		// id,labelの取得
		public int getId() {
            return this.id;
        }
		public String getLabel() {
			return this.label;
		}

		// 指定のIDをもつ干支を取得(該当しない場合はnullを返す)
		public static Zodiac findById(int id) {
			for(Zodiac zodiac : Zodiac.values()) {
				if(zodiac.getId() == id) {
					return zodiac;
				}
			}
			return null;
		}
		// 指定の名称をもつ干支を取得(該当しない場合はnullを返す)
		public static Zodiac findByLabel(String label) {
			if(label == null) {
				return null;
			}
			for (Zodiac zodiac :Zodiac.values()) {
				if(zodiac.getLabel().equals(label)) {
					return zodiac;
				}
			}
			return null;
		}
	}

	public static void main(String arguments[]) {
		// 該当するidのlabelをもつ干支を出力
		System.out.println(Zodiac.findById(12).getLabel());
		// 該当するlabelのidをもつ干支を出力
		System.out.println(Zodiac.findByLabel("horse").getId());
	}
}

