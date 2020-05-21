package Java_Training.unit_08.practice.no220;

public class Practice8_5_2 implements Practice8_5 {
	
	private String name;
	
	public Practice8_5_2(String name) {
		this.name = name;
	}
	
	@Override
	public void move() {
		System.out.printf("%sは、トコトコ歩きます。", this.name);
	}	
	
	public Practice8_5_2() {
		this("ハムスター");
	}
}
