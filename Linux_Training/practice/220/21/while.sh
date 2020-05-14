#!/usr/bin/bash

read -p "5以上の値を入力してください：" VALUE
if [ $VALUE -lt 5 ]; then
	echo エラー
else
while [ $VALUE -ge 5 ]
do
	echo $VALUE
	let VALUE--
done
fi
