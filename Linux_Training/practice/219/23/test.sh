#!/usr/bin/bash
a=`expr $RANDOM % 100`
while :
do
	echo "１－１００の数字を入力してください"
	read i
	if [ $i -eq $a ]; then
		echo "正解"
		break
	elif [ $i -gt $a ]; then
		echo "正解より大きい"
	elif [ $i -lt $a ]; then
		echo "正解より小さい"
	fi
done

