1.  classにprotectedは利用できない。
    フィールドにvarキーワードは利用できない。
    data引数が宣言したので、IF文の中のvarを重複している。
    なおす：
        public class PClass{
            public int data = 10;
            public void hoge (int data){
                if (data < 0>){
                    data=0;
                }
                System.out.println(data);
            }
        }
2.  フィールドのスコープ：クラス全体からアクセス可能
    ローカル変数のスコープ：メソッド内でのみアクセス可能
    フィールドの宣言：class{...}の下、メソッド外
    ローカル変数の宣言：メソッド内