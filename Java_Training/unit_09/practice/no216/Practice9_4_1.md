public class Practice9_4_1 {
	private String firstName;
	private String lastName;

	public Practice9_4_1(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Person:%s%s",
		this.lastName, this.firstName);
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}
}