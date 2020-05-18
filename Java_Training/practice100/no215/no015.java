package Java_Training.practice100.no215;

public class no015 {
	public static void main(String[] args) {
		no015 no015a=new no015("Kikuchi");
		no015a.Name();
		no015 no015b=new no015();
		no015b.Name();
	}
	public String name;

	no015(String name){
		this.name=name;
	}

	no015(){
		this("no name");
	}
	public void Name(){
		System.out.println(this.name);
	}
	
}

