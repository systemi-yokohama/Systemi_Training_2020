/*
列挙型
ユニークな名前とIDを持ち、名前とIDどちらでもインスタンスが取得できるenumを実装
例として、十二支を表現するenumを実装
*/

package Java_Training.practice100.no212;

public class No018 {
	private enum Eto{
		ne(1,"子"),
		usi(2,"丑"),
		tora(3,"寅"),
		u(4,"卯"),
		tatu(5,"辰"),
		mi(6,"巳"),
		uma(7,"午"),
		hituzi(8,"未"),
		saru(9,"申"),
		tori(10,"酉"),
		inu(11,"戌"),
		i(12,"亥");

		private int id;
		private String name;

		Eto(int id,String name){
			this.id = id;
		this.name = name;
		}

		public int getId(){
			return this.id;
		}

		public String getName(){
			return this.name;
		}

		public static Eto findById(int id) {
            for (Eto eto : Eto.values()) {
                if (eto.getId() == id) {
                    return eto;
                }
			}
		return null;
		}

		public static Eto findByName(String Name) {
            if (Name == null) {
                return null;
            }
            for (Eto eto : Eto.values()) {
                if (eto.getName().equals(Name)) {
                    return eto;
                }
            }
			return null;
		}
	}

			public static void main(String arguments[]) {
				System.out.println(Eto.findById(12).getName());
				System.out.println(Eto.findByName("uma").getId());
	}
}