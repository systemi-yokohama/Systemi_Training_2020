#!/usr/bin/bash

num=`expr $RANDOM % 10`

while :
do
	echo "数字を入力してください"
	read a
	if [ $a -eq $num ]; then
		echo "入力した数字は同一です"
		break
	elif [ $a -gt $num ]; then
		echo "数字はもっと小さいです"
	elif [ $a -lt $num ]; then
		echo "数字はもっと大きいです"
	fi
done

