/*
アノテーション(2)
「3で割り切れる数」を示すフィールド用アノテーションを作成し、
それを用いてコマンドの第1引数に指定された数が3で割りきれる数かどうかをチェックするプログラムを実装
*/

package Java_Training.practice100.no212;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
	@Target({
		ElementType.TYPE,
		ElementType.FIELD,
		ElementType.CONSTRUCTOR,
		ElementType.METHOD
	})
	public @interface Three{
		String value();
	}

public class No032 {
	
}