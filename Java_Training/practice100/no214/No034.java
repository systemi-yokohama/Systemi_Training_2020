package Java_Training.practice100.no214;
/*以下のプログラムの★部分に36文字以内でコードを挿入し、
medalsの内容を1行につき1つずつ標準出力に出力するプログラムにせよ。
public class Knock034 {
    public static void main(String[] arguments) {
        java.util.List<String> medals = new java.util.ArrayList<>();
        medals.add("gold");
        medals.add("silver");
        medals.add("bronze");
        ★
    }
} */
public class No034 {
	public static void main(String[] args){
		java.util.List<String> medals=new java.util.ArrayList<>();
		medals.add("gold");
		medals.add("silver");
		medals.add("bronze");
		for(var value:medals){
			System.out.printf("%s\n",value);
		}
	}
    
}