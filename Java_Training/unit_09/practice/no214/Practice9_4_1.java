package Java_Training.unit_09.practice.no214;

public class Person {
	private String firstName;
	private String lastName;
	
	public Person(String firstName ,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return String.format("Person:%s %s", this.firstName,this.lastName);
	} 
	
}


  
