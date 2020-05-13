#!/usr/bin/bash

echo -n 数字を入力してください:
read str
if [ $str -ge 1000 ]; then
	echo 1000以上です
elif [ $str -ge 100 ] &&[ $str -lt 1000 ]; then
	echo 100以上、1000未満です
elif [ $str -lt 100 ]; then
	echo 100未満です
fi
