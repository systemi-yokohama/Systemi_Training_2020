/*
リフレクション
・java.lang.StringBufferクラスのインスタンスを生成しappend(String)メソッドを呼び出すコードを
リフレクションを用いて実装
・java.lang.StringBufferクラス以外のメソッド呼び出しはリフレクションを使用しなくてよい
*/

package Java_Training.practice100.no212;

import java.lang.StringBuffer;

public class No029 {
	public static void main(String arguments[]) {
	var clazz = StringBuffer.class;
}
}