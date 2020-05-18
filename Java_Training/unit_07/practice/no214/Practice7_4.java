package Java_Training.unit_07.practice.no214;
class Main{
	public static void main(String[] args){
var value=new int[]{10,20,30};
var p =new Practice7_4();
System.out.println(p.change(value)[0]);//①100:100
System.out.println(value[0]);//②100:10
	}
}

public class Practice7_4 {
	public int[] change(int[] value){
		value[0]=100;//③100,200,300
		return value;
	}
}
