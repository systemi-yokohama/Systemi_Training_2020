package Java_Training.unit_10.practice.no217;

@FunctionalInterface 
	public interface Foo<T,R> {
		R process(T v1, T v2);
	}
