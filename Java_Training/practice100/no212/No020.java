/*
ジェネリクス
以下の配列MEDALSについて、ジェネリクスを用いた場合のリストと用いない場合のリストにそれぞれ要素を入れ、
それぞれのリストについて、全要素を順番に出力するためのプログラムを実装
private static final String[] MEDALS = new String[]{
    "GOLD", "SILVER", "BRONZE"
};
*/

package Java_Training.practice100.no212;

import java.util.ArrayList;
import java.util.List;

public class No020 {
	private static final String[] MEDALS = new String[]{
		"GOLD", "SILVER", "BRONZE"
	};
public static void main(String arguments[]) {
	NonGeneList();
	GeneList();
}

private static void NonGeneList() {
	List nonGeneList = new ArrayList();
	for (String medal : MEDALS) {
		nonGeneList.add((String) medal);
	}
	for (int i = 0; i < nonGeneList.size(); i++) {
		System.out.println((String) nonGeneList.get(i));
	}
}

private static void GeneList() {
	List<String> geneList = new ArrayList<String>();
	for (String medal : MEDALS) {
		geneList.add(medal);
	}
	for (String item : geneList) {
		System.out.println(item);
	}
}

}