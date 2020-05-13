#!/usr/bin/bash
num=`expr $RANDOM % 10`
while :
do
echo "0～9の数値を入力"
read Number

	if [ $Number -eq $num ]; then
		echo "正解！$num"
		break
	elif [ $Number -gt $num ]; then
		echo "もっと小さい"
	elif [ $Number -lt $num ]; then
		echo "もっと大きい"
	fi
done
