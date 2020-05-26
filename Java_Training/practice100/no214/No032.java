package Java_Training.practice100.no214;
/*アノテーション(2)unit 11
「3で割り切れる数」を示すフィールド用アノテーションを作成し、
それを用いてコマンドの第1引数に指定された数が3で割りきれる数かどうかを
チェックするプログラムを実装せよ。 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class No032 {
	@Documented
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface ThreeMult{
		int value();
	}
	    int number;
		@ThreeMult(231)
		public void Thm(int number){
			if (0==number%3){
				System.out.println(number + ":３の倍数");
			}else{
				System.out.println(number + ":３の倍数ではない");
			}
		}
	
}