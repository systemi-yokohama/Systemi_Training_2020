package Java_Training.unit_09.practice.no210;
import java.util.ArrayList;

public class Practice9_4 {
	//1
	private String firstName;
	private String lastName;

	public Practice9_4(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Person：%s %s", this.lastName, this.firstName);
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	
	public static void main(String[] args) {

		//2
		var m = Weekday.valueOf("Monday");
		System.out.println(m instanceof Weekday);

		//3
		try {

		} catch(IOException | SQLException e) {

		}

		//4
		private static class Sub {};
	}

	//5
	public static <T> ArrayList<T> newArrayList(T... data) {
		var list = new ArrayList<T>();

		for(var dt : data) {
			list.add(dt);
		}

		return list;
	}
}