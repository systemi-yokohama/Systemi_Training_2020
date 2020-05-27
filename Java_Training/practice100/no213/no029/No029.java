package Java_Training.practice100.no213.no029;

import java.lang.reflect.Method;

public class No029 {
	public static void main(String[] args) {
		try {
			Class<?> class1 = StringBuffer.class;
			Object obj = class1.getConstructor(String.class).newInstance("");
			Method meth = class1.getMethod("append", String.class);
			System.out.println(meth.invoke(obj, "aaa"));
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
}