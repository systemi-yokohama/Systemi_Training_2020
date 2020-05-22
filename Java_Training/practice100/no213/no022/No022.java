package Java_Training.practice100.no213.no022;

public class No022 {
	static void command(int... values) {
		for(int value : values) {
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		Integer[] list =  {1, 33, 133, 382, 122, 32, 544,3};
		var ts = list.length;
		if(ts == list[2]) {
			command(list[0], list[1]);
		} else if(ts == list[4]) {
			command(list[1], list[2], list[4]);
		} else if(ts == list[7]) {
			command(list[0], list[3], list[5], list[6]);
		} else {
			System.out.println("Usage");
		}
	}
}