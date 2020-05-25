package Java_Training.practice100.no210.no032;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**「3で割り切れる数」を示すフィールド用アノテーションを作成し、
それを用いてコマンドの第1引数に指定された数が3で割りきれる数か
どうかをチェックするプログラムを実装せよ。*/

public class No032 {
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface NumberCheck {
		String description() default "3で割り切れるかチェックする";
	}
	

}