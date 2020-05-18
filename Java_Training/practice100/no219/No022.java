package Java_Training.practice100.no219;

public class No022 {
	public static void main(String... args) {
		int len =args.length;
		switch (len){
			case 3:
				System.out.printf(args[0], args[1]);
				break;
			case 5:
				System.out.printf(args[0], args[1]);
				break;
			case 7:
				System.out.printf(args[0], args[1]);
				break;
			default:
				System.out.println("usage");
				break;


		}

	}
}