// 問1
	@FunctionalInterface
	public interface Hoge {
		void print(String str);
	}
    
	// 問2
	@FunctionalInterface
	public interface Foo<T,R> {
		R process(T v1, T v2);
	}

	// 問3
	var list = new ArrayList<String>(
		Arrays.asList("ABCDE", "OP", "WXYZ", "HIJKL")
	);
	list.replaceAll(v ->{
		if(v.length() < 3) {
			return v;
		} else {
			return v.substring(0, 3);
		}
	});

	// 問4
	Stream.of("シュークリーム", "プリン", "マドレーヌ", "ババロア")
	.sorted((str1, str2) -> str2.length() - str1.length())
	.forEach(System.out::println);

	// 問5
	var list = new int[] {60, 95, 75, 80, 70};
	System.out.println(IntStream.of(list).max().orElse(0));
	System.out.println(IntStream.of(list).average().orElse(0));