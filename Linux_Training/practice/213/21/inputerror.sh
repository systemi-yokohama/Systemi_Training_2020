#!/usr/bin/bash

echo "5以上の数字を入力してください "
read number
if [ $number -ge "5" ]; then
	echo "出力"
	while [ $number -ge "5" ];
	do
		echo "$number"
		num=`expr $num - 1`
	done
	echo "終わり"
else
	echo "5以上の数字ではありません"
fi
