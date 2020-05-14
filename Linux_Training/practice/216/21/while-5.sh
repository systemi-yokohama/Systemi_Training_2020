#!/usr/bin/bash

echo "5以上で入力してください"
read num

if [ $num -ge "5" ]; then
	while [ $num -ge "5" ]; do
		echo "$num"
		num=`expr $num - 1`
	done
else
	echo "5以上で入力してください"
fi
