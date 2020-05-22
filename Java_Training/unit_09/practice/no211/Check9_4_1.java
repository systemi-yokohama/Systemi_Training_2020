package Java_Training.unit_09.practice.no211;

public class Check9_4_1 {
	public class Person{
		private String firstName;
		private String lastName;

		public Person(String firstName, String lastName){
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String toString(){
			return this.firstName + this.lastName; 
		}
	}
}