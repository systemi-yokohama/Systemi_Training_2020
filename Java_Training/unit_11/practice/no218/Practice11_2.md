1. メソッドがjava9以降では非推奨であることを、アノテーションを使った表現してみよう
  

2. リフレクション経由でStringクラスのsubstringメソッドを呼び出すためのコードです。空欄を埋めてください
  ```
  var clazz = String.①;
  var con = clazz.②(String.①);
  var str = con.③("こんにちは、java!");
  var m = clazz.④("substring", int.①, int.①);
  System.out.println(m.⑤(str, 6, 10)); //結果:java
  ```
  ①class　②getConstractor　③newInstance　④getMethod　⑤invoke