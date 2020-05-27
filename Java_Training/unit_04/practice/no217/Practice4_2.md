### 第四章 制御構文 練習問題4.2            
1. whileとdo-whileの違い      
    * while     
        条件がtrueの場合に処理が繰り返される        
    * do-while      
        条件がfalseの場合でもブロック内の処理が行われる     
2. for文を用いて九九表を作成        
    ```
    for( int i=1; i<=9; i++ ) {
        for( int j=1; j<=9; j++ ) {
             System.out.print(i*j + ",");
         }
              System.out.println(); 
         }
    ```