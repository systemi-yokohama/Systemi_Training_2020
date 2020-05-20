package Java_Training.practice100.no220.no015;

public class No015 {
	public String name;
	
	public No015(String name) {
		this.name = name;
	}

	public No015() {
		this("no name");
	}
	
	public static void main(String[] args) {
		No015 name1 = new No015("tom");
		No015 name2 = new No015();
		System.out.println("私の名前は" + name1.name);
		System.out.println(name2.name);
		
	}
}
	
