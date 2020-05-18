package Java_Training.practice100.no210.no022;

public class No022 {
	public static void main(String[] args) {

		switch(args.length) {
			case 3:
				write(args[0], args[1]);
				break;
			case 5:
				write(args[1], args[2], args[4]);
				break;
			case 7:
				write(args[0], args[3], args[5], args[6]);
				break;
			default:
				System.out.println("usage");
				System.exit(2);
				break;
		}
	}

	public static void write(String... values) {
		for(var value : values) {
			System.out.println(value);
		}
	}
}