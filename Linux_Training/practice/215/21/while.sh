#!/usr/bin/bash
echo "値を入力："
read num
if [ $num -ge "5" ]; then
	
	while [ $num -ge "5" ]; do
	echo "$num"
	num=`expr $num - 1`
	done
else
	echo "5以上の値ではありません"
fi

