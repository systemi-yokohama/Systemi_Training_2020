/* [1]
	while文はループの先頭で条件式を判定するが
	do while文はループのあとに条件式を判定する。
	*/




package Java_Training.unit_04.practice.no213;

public class Practice4_2 {
	public static void main(String[] args) {
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; i++) {
				int seki = i * j;
				System.out.print(seki);
			}
		}	
	}
}