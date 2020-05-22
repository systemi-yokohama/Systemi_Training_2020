/*
・コアAPI:java.util.stream
・1から100までの整数に含まれる偶数だけを加算した結果を求めるプログラムをストリームAPIを使用して実装
・API=アプリケーションプログラミングインタフェース
・APIは自己のソフトウェアを一部公開して、他のソフトウェアと機能を共有できるようにしたもの
*/
package Java_Training.practice100.no212;

import java.util.stream.IntStream;

public class No054{
public static void main(final String[] args) {
IntStream.rangeClosed(1,100);
var i = rangeClosed;
if(i % 2 != 0) {
	continue;
}
sum += i;
}
}

/*
public class evenNumber{
	public static void main(String[]args{
	List<String>list=Arrays.atList(1,100));
	sum=Arrays.atList
	System.out.println(sum);

	
	}
}
*/