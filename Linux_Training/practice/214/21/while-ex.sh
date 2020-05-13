#!/usr/bin/bash

#入力された値をデクリメントしながら表示
#５になった時点で終了するスクリプトを作成せよ
#(「5」未満の入力はエラーメッセージを表示すること
echo "5以上の数値を入力してください"
read num

if [ $num -ge "5" ]; then
	  echo "出力"
           while [ $num -ge "5" ]; do
 	        echo "$num"
    		num=`expr $num - 1`
           done
            echo "終わり"
    else	
   	    echo "5以上の数値ではありません。"
fi
