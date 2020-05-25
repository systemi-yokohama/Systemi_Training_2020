package Java_Training.practice100.no217.No032;
import java.lang.reflect.Field;
import java.lang.NoSuchFieldException;
import java.lang.IllegalAccessException;

public class No032_1 {
	// コマンド入力時に第1引数で受け取った数値が3で割り切れるかを判定
	public static void main(String arguments[]) {
        No032_4 argNum = new No032_4();

        if (arguments.length >= 1) {
            try {
                argNum.num = Integer.parseInt(arguments[0]);

                if (isDivisibleNumberByThree(argNum)) {
                    System.out.println("3で割り切れる値が入力されました");
                } else {
                    System.out.println("3で割り切れない値が入力されました");
                }
            } catch (NumberFormatException | No032_3 | NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
	}
	
	/*
		@No032_2を付与したフィールドの値が3で割り切れる値であることを判定する.
		@param Number number @No032_2を付与したフィールドを持つクラスのオブジェクト
		@throws No032_3 @No032_2を付与したフィールドがない場合
		@throws NoSuchFieldException フィールドが見つからない場合
		@throws IllegalAccessException フィールドにアクセスできない場合
		@return 値が3で割り切れる場合はtrueを返す。3で割り切れない場合はfalseを返す。
    */
	private static boolean isDivisibleNumberByThree (No032_4 number)
        throws No032_3, NoSuchFieldException, IllegalAccessException {
        Field field = number.getClass().getDeclaredField("num");
        // fieldに@No032_2が付与されている場合
        if (field.getAnnotation(No032_2.class) == null) {
            throw new No032_3("@No032_2が付与されているフィールドがありません");
        }

        int fieldNum = (int) field.get(number);
        return (fieldNum % 3 == 0);
    }
}