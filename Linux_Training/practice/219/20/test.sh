#!/usr/bin/bash
echo "数字を入力してください"
read num

if [ $num -lt 100 ] 
then
	echo "１００未満です"
elif [ $num -ge 100 -o $num -lt 1000 ] 
then
	echo "１００以上１０００未満です"
elif [ $num -ge 1000 ]
then
	echo "１０００以上です"
fi
