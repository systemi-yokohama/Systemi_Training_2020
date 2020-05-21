package Java_Training.unit_08.practice.no216;

public class P8_2 implements Practice8_5 {
	private String name;

	public P8_2 (String name) {
		this.name = name;
	} 

	@Override
	public void move() {
		System.out.printf("%sは、トコトコ歩きます。", this.name);
	}
}