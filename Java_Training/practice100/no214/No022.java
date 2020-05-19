package Java_Training.practice100.no214;
/*Javaコマンドの引数の数が
3個の時は1個目と2個目、
5個の時は2個目と3個目と5個目、
7個の時は1個目と4個目と6個目と7個目を、
同一のメソッドに渡し、
そのメソッドでは渡された引数を標準出力に1行につき1つずつ出力するプログラムを実装せよ。
引数の数が3,5,7のいずれでもない場合はusageを出力して復帰コード2で終了するようにせよ。 */
public class No022 {
	public static void VariadicArguments(int...values){
		 var sum=values.length;
		 if(sum<8 && (1==sum%2)){
	     	for(var value:values){
				System.out.println(value +"\n");
			}
		}else{
			System.out.println("usage");
			System.exit(2);
		
		}
	}
}
class Main{
 public static void main(String[] args) {
var data=new int[]{0,1,2,3,4,5,6,7,8,9,10};
var p=new No022();
p.VariadicArguments(data[0],data[1]);
p.VariadicArguments(data[1],data[2],data[4]);
p.VariadicArguments(data[0],data[3],data[5],data[6]);

}
}