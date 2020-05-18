package Java_Training.unit_07.practice.no214;

public class Practice7_3 {
	public String name;
	public int age;
	public Practice7_3(String name,int age){
		this.name=name;
		this.age=age;
	}
    public Practice7_3(){
		this("権兵衛",0);
	}
public void show(){
	System.out.printf("%s(%d歳)です。\n",this.name,this.age);
}
}