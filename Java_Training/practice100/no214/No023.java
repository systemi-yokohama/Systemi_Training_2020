package Java_Training.practice100.no214;
/*「オーバーロード」同一の名称で、int型1つを引数に取るメソッドとfloat型1つを引数に取るメソッドを作成し、
それぞれのメソッドでは渡された引数を文字列に変換して返すように実装せよ */
public class No023 {
public int number1;
public float number2;

public No023(int number1,float number2){
	this.number1=number1;
	this.number2=number2;
}

public String StringChange(int number1){
	
	 String str = String.valueOf(number1);
	return str;

}
public String StringChange(float number2){
	
	String str = String.valueOf(number2);
	return str;
	}

}
