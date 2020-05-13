#!/usr/bin.bash

busy=0

for date in 月曜日 火曜日 水曜日 木曜日 金曜日 土曜日 日曜日
do
	read -p "$date は忙しいですか(y/n)" yn
	case $yn in
		"y") busy=`expr $busy + 1`;; 
		"n") continue;;
	esac
done

echo "$busy 日、忙しい日がありました。"
