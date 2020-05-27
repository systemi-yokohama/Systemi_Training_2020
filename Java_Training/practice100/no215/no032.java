package Java_Training.practice100.no215;

/*「3で割り切れる数」を示すフィールド用アノテーションを作成し、
それを用いてコマンドの第1引数に指定された数が3で割りきれる数かどうかをチェックするプログラムを実装せよ。*/

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class no032 {
	@Retention( RetentionPolicy.RUNTIME )
	public @interface Ant032{
		int num=0;
		if(i%3==0){
			num+=i;
		}
	}
}