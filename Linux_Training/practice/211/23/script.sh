#!/usr/bin/bash

num=`expr $RANDOM % 10`

while : 
do
	read -p "number:" read
	if [ $num -eq $read ]; then
		echo "入力値とnumは等しいです"
		break
	elif [ $num -gt $read ]; then
		echo "入力値はnumより小さいです"		
	elif [ $num -lt $read ]; then
		echo "入力値はnumより大きいです"
	fi
done
