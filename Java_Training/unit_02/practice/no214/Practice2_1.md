[1]

リストのコードで間違っている点を３つ挙げてください。

- data ='こんにちは、世界！';　…変数宣言にはStrかvarが必要。
- data ='こんにちは、世界！';　…文字リテラルには''ではなく、""を使う。
- System.out.println(data) …文の末尾にセミコロンが必要。

訂正前  
package to.msn.wings.selhlearn.chop02.practice;  
public class  Practical{  
　public static void main(String[] args){  
 　　data ='こんにちは、世界！';  
 　　System.out.println(data)  
　}    
}

訂正後  
package to.msn.wings.selhlearn.chop02.practice;  
public class  Practical{  
　public static void main(String[] args){  
 　　Str data ="こんにちは、世界！";  
 　　System.out.println(data);  
　}    
}