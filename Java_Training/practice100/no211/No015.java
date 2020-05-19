package Java_Training.practice100.no211;

public class No015 {
	private String name;

	No015(String name){
		this.name = name;
	}
	No015(){
		this("no name");
	}

	public static void main(String[] args) {
		System.out.println(new No015("nm").name);
	}
	
}
//→〇