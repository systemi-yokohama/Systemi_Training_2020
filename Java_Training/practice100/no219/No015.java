package Java_Training.practice100.no219;

public class No015 {
	public String name;
	public No015(String name){
		this.name =name;
	}
	public String show(){
		if (this.name==null){
			return "no name";
		}else{
			return name;
		}
	}
}
