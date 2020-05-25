1. public class MyRunner implements Thread{...}
   スレッドクラスを使うのであれば、implementsではなくextendsで継承する
2. synchronized void increment(){...}
    正しい
3. var sche=Executors.newSingleThreadScheduledExecutor(3);
    引数を入れない
4. @Override
    public String toString(){...}
    正しい
5. opens module mylib{...}
    opensではなくopen
    opensはブロック内で使う