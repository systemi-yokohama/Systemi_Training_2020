package Java_Training.unit_09.practice.no214;

import java.util.List;
//import java.util.Arrays;
import java.util.ArrayList;
class Practice9_4_5{

//任意の要素を可変長引数で受け取って、
//新規にArrayListを生成する静的メソッドnewArrayListを実装する

public static <T> ArrayList <T> newArrayList(T data){//(引数の型　引数名)

	return new ArrayList<T>(List.of(data));

}

}