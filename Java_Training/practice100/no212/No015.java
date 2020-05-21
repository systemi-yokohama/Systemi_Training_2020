/*
コンストラクタ（１）
・java.lang.String型のインスタンス変数を持つクラスで、コンストラクタでその変数に代入すべき値をとる場合と
とらない場合がある。取らない場合、デフォルトの文字列"no name"を設定する。このクラスを実装
*/

package Java_Training.practice100.no212;

public class No015{
	public String name;

        public No015(){
	this(name);
	}

	public No015(String name1){
	this.name = name1;
	}


}
