package Java_Training.unit_09.practice.no107;

public class TryException {
	public static void main(String[] args) {

		System.out.println("変数宣言 tryNull");
		String tryNull = null;

		try {

			System.out.println("変数宣言 lengthの取得");
			String[] tryOver = { "あ", "い", "う", "え", "お" };

			System.out.println("変数の利用 tryOverの格納データ取得");
			for (int i = 0; i < tryOver.length; i++) {
				System.out.println(tryOver[i]);
			}

			System.out.println("変数の利用 tryNullのlengthの取得");
			System.out.println(tryNull.length());

			System.out.println("変数の利用 tryOverのlengthの取得");
			System.out.println(tryOver.length);

		} catch (Exception e) {

			System.out.println("不正な値です");
		}

	}
}