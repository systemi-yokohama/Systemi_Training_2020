package Java_Training.practice100.no214;
//java.lang.String型のインスタンス変数を持つクラスで、
//コンストラクタでその変数に代入すべき値を取る場合と、取らない場合がある。
//取らない場合、デフォルトの文字列"no name"を設定する。このクラスを実装せよ。
public class No015 {
public String name;
//変数に値を取る場合
public No015(String name){
	this.name=name;
}
//変数に値を取らない場合
public No015(){
	
		this("no name");
	
}
	
}