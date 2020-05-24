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
		 if(sum==3){
			for(int i=1;i <= values.length ;i++){
				if(i==3){
					continue;
				}
				System.out.printf(values +"\n");
				
			} 
		 }else if(sum==5){
			for(int i=1;i <= values.length ;i++){
				if(i==1|i==4){
					continue;
				}
				System.out.printf(values +"\n");
		 }
		}else if(sum==7){
			for(int i=1;i <= values.length ;i++){
				if(i==2|i==3|i==5){
					continue;
				}
				System.out.printf(values +"\n");
		 }
		}else{
			System.out.println("usage");
			System.exit(2);
		}
	}
}
