// // 問1
	public static void main(String[] args) {
		Practice9_4 person = new Practice9_4("first", "last");
		System.out.println(person);
	}

	private String firstName;
	private String lastName;

	public Practice9_4(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString() {
		return String.format("Person：%s %s です。", this.firstName, this.lastName);
	}

	// 問2
	public enum Weekday {
		Monday,
	};
	public static Weekday day = Weekday.Monday;
	
	public static void main(String[] args){
	System.out.println(day instanceof Weekday);
	}

	// 問3
	try {
	} catch(IOException | SQLException e) {
	}

	// 問4
	public class Main {
		private static class Sub {
		}
	}

	// 問5
	public static <T> ArrayList<T> new ArrayList(T... list) {
		return new ArrayList<T>(List.of(list));
	}