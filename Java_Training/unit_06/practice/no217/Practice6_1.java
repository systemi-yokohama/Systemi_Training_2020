package Java_Training.unit_06.practice.no217;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice6_1 {
	public static void main(String[] args){
        // 02.ArrayListの作成
        List<Integer> list = new ArrayList<>(Arrays.asList(16,24,30,39));
        System.out.println(list);
        // 02.ArrayListの更新
        list.set(0,20);
        System.out.println(list);
	}
}