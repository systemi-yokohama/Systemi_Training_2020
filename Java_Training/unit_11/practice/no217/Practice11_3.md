### 第十一章 理解度チェック        
1. 正誤チェック     
    1. x(スレッドプールを利用して再利用するべき)
        スレッドプール      
            1度作ったスレッドを可能な限り使いまわすような仕組み
                一定数のスレッドを常に立てておく。 （CPU 数と同じ数だけスレッドが動いている状態が理想。）       
                タスクを待たせておくためのキューを持つ。        
                現在処理中のタスクが終わり次第、次のタスクをキューから取り出して実行する。      
    2. x(説明はjava.util.concurrent.locksのもの)        
    3. x(指定できるのは基本型,文字列型,列挙型,class型,アノテーション型など)     
    4. x(java.baseの誤りであり.seは標準ライブラリ全体を含むモジュール)      
    5. x(自動モジュールの誤り)      
        無名モジュール->非モジュールをクラスパスに配置することで扱われる        
        自動モジュール->モジュール定義ファイルを持たないライブラリをモジュールパスに配置した場合無名モジュールとして扱われる        
2. コード穴埋め     
    1. newSingleThreadExecutor
    2. ()->     
    3. Random       
    4. Sleep        
    5. get      
3. コード修正       
    1-1. 「スレッド生成」public class MyRunner implements Runnable{...}     
    1-2. 「スレッドからスレッド生成」public class MyRunner extends Runnable{...}        
    2. 正しい       
    3. var sche = Executors.newScheduledthreadPool(2);      
        複数スレッドを用意する場合はnewScheduledthreadPoolメソッドを使う        
    4. 正しい       
    5. open mudule mylib {...}      
        モジュールは以下のパッケージをすべてopen扱いにする場合は、moduleキーワードの前方にopenを付与する        
4. コード穴埋め     
    1. CompeletableFuture       
    2. thenApplyAsync       
    3. (data)->     
    4. thenacceptAsync      

