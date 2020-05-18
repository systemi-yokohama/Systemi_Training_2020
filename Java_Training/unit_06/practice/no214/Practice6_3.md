import java.util.ArrayList;  
import java.util.Arrays;  
//中略  
var list =new Array(Arrays.asList(1,2,3,4));  
list.add(100);//末尾に100を代入  (1,2,3,4,100)
list.set(2,30);//2番目に30を設定  (1,2,30,4,100)
list.remove(5);5を削除?? 結果として4がないので3のはずである 
for(String i:list){  
    System.out.println(i);  
}  
//結果：1,2,30,100  
 **誤りを３つ指摘してください。**
- new ArrayList<...>と値の型を定義する必要がある。
- remove(5)→(3)
- for文のStringはintかvarでなければならない。
