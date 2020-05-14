#!/usr/bin/bash

echo "５以上の数字を入力してください"
read n

if [ $n -ge 5 ];then
	while [ $n -ge 5 ]; do
		echo "$n"
		n=`expr $n - 1`
	done
	echo "終了"
else
	echo "エラー"
fi
