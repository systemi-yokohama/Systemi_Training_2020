package Java_Training.practice100.no214;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*リフレクション unit11
java.lang.StringBufferクラスのインスタンスを生成し
append(String)メソッドを呼び出すコードをリフレクションを用いて実装せよ。
java.lang.StringBufferクラス以外のメソッド呼び出しはリフレクションを使用しなくてよい。 */
public class No029 {
	public static void main(String[] args){
		try {
		var clazz=StringBuffer.class;
		var f1=clazz.getConstructor(String.class).newInstance("http://data.txt");
		Method method1 = clazz.getDeclaredMethod("append");
		method1.setAccessible(true);  
		System.out.println(method1.invoke(method1,f1)); 
		} catch (NoSuchMethodException e) {
			System.out.println("一致するメソッドはありません");
			e.printStackTrace();
		  }catch(Exception e){
			  e.printStackTrace();
		  }

	}
}
	

class StrClass{

	 public String name="kakikukeko";

	 public String append(String name){
		 return name ;
	 }
	 

}