[1]  
×  
×  
×  
×  
×  

→〇  
//
- java.util.concurrent.locks: 明示的ロック  
- java.util.concurrent.atomic: ロックフリーな排他的制御  
<br>
- 暗黙的ロード=java.base  
<br>  
- モジュール定義ファイルを持たない: 自動モジュール  
- 無名モジュールはクラスパスに配置された.jarファイル  


[2]  
1: newSingleThreadExecutor  
2: newThreadCallable()　→ () ->  
3: newSingleThreadScheduledExecutor　→Random  
4: sleep  
5: get  

[3]  
1: 正しい  
→implements Runnable/extends Thread(Threadはクラス)  
2: 正しい  
3: (3) : ()  
4: 正しい  
5: : module selflearn{}　→open module mtlib{}=sがいらない  

[4]  
1: CompletableFuture  
2: thenApplyAsync  
3: (data)->  
4: thenAcceptAsync  

//→〇
