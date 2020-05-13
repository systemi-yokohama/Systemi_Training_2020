#!/usr/bin/bash

echo -n "数字を入力してください:"
read a

if [ $a -lt '100' ]; then
	echo "100未満です"
elif [ $a -ge '100' ] && [ $a -lt '1000' ]; then
	echo "100以上1000未満です"
elif [ $a -ge '1000' ]; then
	echo "1000以上です"
fi

