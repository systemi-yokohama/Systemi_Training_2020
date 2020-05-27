package Java_Training.practice100.no214;


//他クラスからインスタンスを作成できないクラスを実装せよ。
//
public class No016 {
public String name;
public int age;
public int address;
//アクセス修飾子：privateはほかのクラスからアクセスできない
	private No016(String name,int age,int address){
		this.name=name;
		this.age=age;
		this.address=address;
	}

}