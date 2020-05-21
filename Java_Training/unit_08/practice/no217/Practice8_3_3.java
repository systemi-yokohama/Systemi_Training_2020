package Java_Training.unit_08.practice.no217;

public class Practice8_3_3 {
	public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(animal.intro());
		}
	}
		class Animal {
		private String name;
		private int age;
		public Animal(String name, int age) {
			this.name = name;
			this.age = age;
		}
		// コンストラクター
		public Animal() {
			this("権兵衛", 0);
		}   

		// アクセサリーメソッド
		public String getName() {
			return this.name;
		}
		public int getAge() {
			return this.age;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			if(age < 0) {
				age = 0;
			} else
			this.age = age;
		}
		
		// メソッド
		public String intro() {
			return String.format("わたしの名前は%s。%d歳です", getName(), getAge());
		}
	}
