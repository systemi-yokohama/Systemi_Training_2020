#!/usr/bin/bash

echo "5以上で数字を入力してください:"
read a

if [ $a -ge '5' ]; then
	while [ $a -ge '5' ]; do
		echo "$a"
		let a--
	done
else
	echo "5以上の数字を入力してください"
fi
