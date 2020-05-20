/*
可変長引数
・Javaコマンドの引数の数が３個の時は１個目と2個目、5個の時は2個目と3個目と5個目、7個の時は1個目と4個目と6個目と7個目を、
同一のメソッドに渡し、そのメソッドでは渡された引数を標準出力に1行につき１つずつ出力するプログラムを実装
・引数の数が３、５、７のいずれでもない場合はusageを出力して復帰コード２で終了するようにする
*/
package Java_Training.practice100.no212;

public class No022{
       public int command(int... numbers){
       swtich(numbers.length){
	       case 3:
	        number(numbers[0],numbers[1]);
		break;
	       case 5:
		number(numbers[1],numbers[2],numbers[4]);
		break;
	       case 7:
		number(numbers[0],numbers[3],numbers[5],numbers[6]);
		break;
	       default:
		System.out.println("Usage");
		break;
	   }
       }

}
