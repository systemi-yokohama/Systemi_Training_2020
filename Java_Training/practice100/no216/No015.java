package Java_Training.practice100.no216;

public class No015 {
	
		private String str;

		No015(final String str) {
			this.str = str;
		}
		No015() {
			this("no name");
		}

		public static void main(String[] args) {
			System.out.println(new No015("Itly"));
			System.out.println(new No015().str);
		}
	
}