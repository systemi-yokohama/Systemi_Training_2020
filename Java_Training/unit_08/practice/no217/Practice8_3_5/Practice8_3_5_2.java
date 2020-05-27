package Java_Training.unit_08.practice.no217.Practice8_3_5;

public class Practice8_3_5_2 implements Practice8_3_5_3 {
	
	private String name;
	
	public Practice8_3_5_2(String name) {
		this.name = name;
	}
	
	@Override
	public void move() {
		System.out.printf("%sは、トコトコ歩きます。", this.name);
	}	
	
	public Practice8_3_5_2() {
		this("ネズミ");
	}
}
