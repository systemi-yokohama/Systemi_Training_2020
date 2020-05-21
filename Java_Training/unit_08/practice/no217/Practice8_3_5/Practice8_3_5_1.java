package Java_Training.unit_08.practice.no217.Practice8_3_5;

public class Practice8_3_5_1 {
	private String name;
	private int age;

	public Practice8_3_5_1() {
		this("名無権兵衛", 0);
	}

	public Practice8_3_5_1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if (age < 0) {
		age = 0;
		}
		this.age = age;
	}

	public String intro() {
		return String.format("わたしの名前は%s。%d歳です。", getName(), getAge());
	}
}