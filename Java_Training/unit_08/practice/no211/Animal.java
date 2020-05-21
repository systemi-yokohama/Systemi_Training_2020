package Java_Training.unit_08.practice.no211;

public class Animal {
	public String name;
	public int age;
	//→フィールド値はprivateにしておく!!!

	public Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	public Animal(){
		this("名無権兵衛", 0);
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return this.age;
	}

	public void setAge(int age){
		if(age < 0){
			this.age = 0;
		}
		else{
			this.age = age;
		}
	}

	public String intro(){
		return String.format("私の名前は%s。%d歳です。", getName(), getAge());
	}
}