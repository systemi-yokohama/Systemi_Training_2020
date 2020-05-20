/* [1]
	×
	×
	×
	〇
	×

   [2]
	①interface
	②default
	③extends
	④implements
	⑤IFather.super
	⑥IMother.super
   */


   /* [3]
		フィールドをprivate表記にする
		コンストラクタにvoidは要らない
		インスタンスフィールドをメソッドで扱うときはthisをつける
		"アクセサリーメソッド"ではなく"アクセサーメソッド"
		セッターは戻り値がない
		$s, $dではなく%s, %d表記*/

package Java_Training.unit_08.practice.no213;

public class Check8 {
	public class Animal {
		private String name;
		private int age;

		public Animal() {
			this("名無権兵衛", 0);
		}
		public Animal(String name, int age) {
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return this.name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return this.age;
		}
		public void setAge(int age) {
			if(age < 0) {
				age = 0;
			}
			this.age = age;
		}
		public String intro() {
			return String.format("わたしの名前は%s。%d歳です。", getName(), getAge());
		}
	}
}

/* [4]
	①format
	②%.2f
	③extends
	④@override
	⑤super.show()
	
   [5]
   　moveメソッドの出力とブロックを消して末尾にセミコロンをつける
	実装クラスはextendsではなくimplements
	orverrideを消してひとつ上の行に@Overrideを加える*/