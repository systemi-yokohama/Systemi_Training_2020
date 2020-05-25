package Java_Training.practice100.no210.no029;
import java.lang.StringBuffer;
import java.lang.reflect.InvocationTargetException;

public class No029 {
	public static void main(String[] args)  {
		
		try {
			//StringBufferクラスを取得
			var cls = StringBuffer.class;

			//オブジェクト生成
			var cstr = cls.getConstructor(StringBuffer.class);
			var obj = cstr.newInstance();

			//append(String)メソッドを取得、実行
			var meth = cls.getMethod("append", StringBuffer.class);
			System.out.println(meth.invoke(obj));
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		
	}
}