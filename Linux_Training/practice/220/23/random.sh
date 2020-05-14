#!/usr/bin/bash
num=$(($RANDOM % 10))
while :
do
echo 値が一致するまで入力してください：
read VALUE

if [ $VALUE -eq $num ]; then
	echo 正解
	break
elif [ $VALUE -gt $num ]; then
	echo もっと小さい値です
elif [ $VALUE -lt $num ]; then
	echo もっと大きい値です
fi
done
