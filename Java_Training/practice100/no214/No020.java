package Java_Training.practice100.no214;

import java.util.ArrayList;
import java.util.List;


public class No020 {
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
