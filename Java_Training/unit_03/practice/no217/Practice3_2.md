### 第三章 演算子 練習問題3.2       
1. 条件演算子       
    ```
    String value = null;
    System.out.println(value == "null" ? "値なし" : value);
    ```     
2. 以下を評価したときの結果をtrue/falseで表示       
    1. "123".equals("123")      
        false        
    2. "123" == "123"       
        エラー               
    3. new StringBuilder("あいう") == new StringBuilder("あいう")       
        false       
    4. Arrays.equals(new int[] {1,2,3}, new int[] {1,2,3})      
        true        
