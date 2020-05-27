package Java_Training.practice100.no218.no15;

public class No15 {

	private  String name;

	public No15(final String name) {
		this.name = name;
		;
	}

	public No15() {
		this("no name");
	}

	public static void main( String[] args) {
		System.out.println(new No15("inoue").name);
		System.out.println(new No15().name);

	}

	
	
}