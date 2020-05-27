package Java_Training.practice100.no217;

public class No023 {
    // int型で渡された引数をString型に変換し返却
    private static String convertString(final int SameName) {
        return String.valueOf("int->Stringへ変換した結果：" + SameName);
    }
    // float型で渡された引数をString型に変換し返却
	private static String convertString(final float SameName) {
        return String.valueOf("float->Stringへ変換した結果：" + SameName);
    }
	public static void main(final String[] args) {
        System.out.println(convertString(1));
        System.out.println(convertString(1f));
    }
}