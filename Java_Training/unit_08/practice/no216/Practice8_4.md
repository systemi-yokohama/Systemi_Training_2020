package Java_Training.unit_08.practice.no216;

public class Practice8_4 {
		public double value;

	public String show() {
		return String.format("値は%.2fです", this.value);
	}
}	

	public class Practice4Sub extends Practice8_4 {
		@Override
		public String show() {
			return String.format("[%s]", super.show());
		}
	}

		var ps = new Practice4Sub();
		ps.value = 123.456;
		System.out.println(ps.show());