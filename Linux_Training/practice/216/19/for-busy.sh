#!/usr/bin/bash

busycnt=0

for week in 月 火 水 木 金 土 日
do
	echo "$week曜日は忙しいですか？(yes/no)"
	read busy

	if [ $busy -eq yes ]; then
		busycnt=$busycnt + 1
	else
		continue
	fi
done

echo "$busycnt日"
