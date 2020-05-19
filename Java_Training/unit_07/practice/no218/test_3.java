package Java_Training.unit_07.practice.no218;

public class test_3 {
	public String name;
	public int age;

	public test_3(String name, int age){
		this.name = name;
		this.age = age;
	}

	public test_3(){
		this("innoue",20);
	}

	public void show(){
		System.out.printf("%s (%d歳)です。\n",this.name,this.age);
	}


}




