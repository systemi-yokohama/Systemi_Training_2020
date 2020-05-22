package Java_Training.unit_10.practice.no217;

// 参考サイト（https://itsakura.com/java-lambda）
// @FunctionalInterfaceは関数型インターフェースであるか確認
@FunctionalInterface 
	// 独自に作成した関数型インターフェース
	// public interface Hoge {
	interface Hoge {
		// void print(String str);
		String print(String str);
	}

// @FunctionalInterface 
// 	public interface Hoge {
// 		void print(String str);
// 	}

public class Practice10_2_3_1 {
	public static void main(String[] args) {
		// 匿名クラス
		Hoge c1 = new Hoge() { // Hogeは4行目のインターフェースを指していて実装
			@Override
			// 9行目のメソッドの内容を記述
			public String print(String str) {
				return str + "です";
			}
		};
		// 23行目で処理を実行
		String b = c1.print("青");
			System.out.println(b); //青です
		}
	}