#!/usr/bin/bash

echo "数字を入力してください "
read number

if [ $number -lt "100" ]; then
	echo "100未満です"
elif [ $number -ge "100" ] && [ $number -lt "1000" ];  then
	echo "100以上1000未満です"
elif [ $number -ge "1000" ]; then
	echo "1000以上です"
fi
