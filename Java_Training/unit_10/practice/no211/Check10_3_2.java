package Java_Training.unit_10.practice.no211;

public class Check10_3_2 {
	//public interface Foo<T>{
	
	//→<>に戻り値のやつも入れる。
	public interface Foo<T,R>{
		R process(T v1, T v2);
	}
}