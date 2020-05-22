### 第九章  理解度チェック                  
1. 正誤チェック   
  1. x（例外が一致または派生クラスである場合に呼び出される）    
  2. x（メンバークラスはstaticで宣言するべき非staticなメンバークラスはメモリを消費するまた、参照の存在がエンクロージングオブジェクトの破棄を妨げることがある）    
  3. ○
  4. x（valuesメソッドで列挙定数を取得nameメソッドは列挙定数の定義名を返す）    
  5. x（ジェネリクスは不変の性質を持つので、型パラメータ同士に継承関係があっても、変数に代入することはできない）    
2. コードの穴埋め   
  1. <T>    
  2. <? super T>    
  3. T...   
  4. add    
  5. result   
3. コード穴埋め   
  1. implements Cloneable   
  2. @override    
  3. Person   
  4. (Person)super.clone()    
  5. this.memos.clone()
  6. CloneNotSupportedException   
4. コード作成   
  1-2.  Practice9_4_4_(1~2).java
  3. 
  ```
    try {
			//
		}
		} catch (IOException| SQLException e) {
			//
		}
  ```
  4. 
  ```
    private static class Sub{
		//
	  }

	public static void main(String[] args) {
		//
	  }
  ```
  5.     
  ```
    public static <T> ArrayList<T>newArrayList(T... data) {
		return new ArrayList<T>(List.of(data));
	  }

	  public static void main(String[] args) {
		  //
	  }
  ```
