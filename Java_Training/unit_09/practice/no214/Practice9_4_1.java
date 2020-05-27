package Java_Training.unit_09.practice.no214;

public class Practice9_4_1 {
	private String firstName;
	private String lastName;
	
	public Practice9_4_1(String firstName ,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	@Override
	public String toString() {
		

		return String.format("Person:%s %s", this.firstName,this.lastName);
	} 
	
}


  
