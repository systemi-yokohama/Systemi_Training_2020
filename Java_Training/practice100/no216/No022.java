package Java_Training.practice100.no216;

public class No022 {
	public static void main(String[] args) {

		if ( args.length == 3) {
			prt(args[0], args[1]);
		} else if(args.length == 5) {
			prt(args[1], args[2], args[4]);
		} else if (args.length == 7) {
			prt(args[0], args[3], args[5], args[6]);
		} else {
			System.out.println("usage:引数の数を3個、5個、7個のいずれかにして再実行してください");
			System.exit(2);
		}
	}

	public static void prt(String... names) {
		for(String name : names) {
			System.out.println(name);
		}
	}
}