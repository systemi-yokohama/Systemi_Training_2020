#!/usr/bin/bash

num=`expr $RANDOM % 10`
echo "数字当てゲーム"

while :
do
echo "0から9数字を入れてください"
read str 
if [ $str -eq $num ]; then
	echo "正解"
	break
elif [ $str -gt $num ]; then
	echo "おおきい"
elif [ $str -lt $num ]; then
			
	echo "ちいさい"	
fi
done
