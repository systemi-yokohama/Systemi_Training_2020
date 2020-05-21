package Java_Training.unit_09.practice.no217;

public class Practice9_4_4_1 {
	public String firstName = "Kaito";
	public String lastName = "Maeda";

	@Override
		public String toString() {
			return String.format("Person:%s %s", this.lastName, this.firstName);
		}

	public static void main(String[] args) {
		Practice9_4_4_1 practice9_4_4_1 = new Practice9_4_4_1();
		String name = practice9_4_4_1.toString();
		System.out.println(name);
	}

}