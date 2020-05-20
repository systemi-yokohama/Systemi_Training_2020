/*
・フィールドがprivateになっていない
・コンストラクタに戻り値はないのでvoidはいらない
・呼び出しにはthisを使う
・セッターには戻り値が必要なのでvoidをつける
・$s,$dではなく%s,%d
*/


package Java_Training.unit_08.practice.no212;

public class practice8_3 {
private String name;
private int age;

//コンストラクタ
public Animal(){
	this("名無権兵衛",0);
}

public Animal(String name,int age){
	this.name = name;
	this.age = age;
}

public String getName(){
	return this.name;
}

public void setName(String name){
	this.name = name;
}

public getAge(){
	return this.age;
}

public void setAge(int age){
	if(age < 0){
		age = 0;
	}
	this.age = age;
}

public String intro(){
	return String.format("私の名前は%s。%d歳です。",getName(),getAge());
}
}