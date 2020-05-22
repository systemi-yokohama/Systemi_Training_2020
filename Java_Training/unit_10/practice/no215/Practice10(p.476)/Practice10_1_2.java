package Java_Training.unit_10.practice.no215.Practice10(p.476);

public class Practice10_1_2 {
	var list=new ArrayList<String>(
		Arrays.asList("ねこ","パンダ","アルマジロ")
	);
	list.removeIf(v -> v.length()<5);
	System.out.println(list);
}