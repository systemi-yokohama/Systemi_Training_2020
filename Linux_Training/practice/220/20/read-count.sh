#!/usr/bin/bash

read -p "値を入力してください：" VALUE

if [ $VALUE -lt 100 ]; then
	echo 100未満です
elif [ $VALUE -ge 1000 ]; then
	echo 1000以上です
else
	echo 100以上1000未満です
fi
