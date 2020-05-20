package Java_Training.practice100.no213.no022;

public class No022 {
	public int command(int... values) {
		for(var value : values) {
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		var ts = args.length;
		if(ts == 3) {
			command(args[0], args[1]);
		} else if(ts == 5) {
			command(args[1], args[2], args[4]);
		} else if(ts == 7) {
			command(args[0], args[3], args[5], args[6]);
		} else {
			System.out.println("Usage");
			return 2;
		}
	}
}