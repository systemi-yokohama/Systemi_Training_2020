package Java_Training.practice100.no214;
/*
以下の配列MEDALSについて、ジェネリクスを用いた場合のリストと用いない場合のリストにそれぞれ要素を入れ、
それぞれのリストについて、全要素を順番に出力するためのプログラムを実装せよ。
private static final String[] MEDALS = new String[]{
    "GOLD", "SILVER", "BRONZE"
};
*/

public class No020A {
	private static final String[] MEDALS = new String[]{
	"GOLD", "SILVER", "BRONZE"
	
	};

	public void main(String[] args){
		//ジェネリックあり
		final List<String> genericListA = new ArrayList<String>();
		for (final String medal : MEDALS) {
			genericListA.add(medal);//付与
		
		}
		for(int i=0;i<=genericListA.size();i++){
	      System.out.println(genericListA.get(i));//取得
		}
		//なし
		final ArrayList genericListB = new ArrayList();
		for (final String medal : MEDALS) {
			genericListB.add(medal);//付与
		}
		for(int i=0;i<=genericListB.size();i++){
			System.out.println(genericListB.get(i));//取得
		  }
	}
}
