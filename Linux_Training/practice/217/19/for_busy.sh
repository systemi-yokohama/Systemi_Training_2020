#!/usr/bin/bash

busy=0

for day in 月曜日 火曜日 水曜日 木曜日 金曜日 土曜日 日曜日;
do
	echo "$dayは忙しいですか？(yes / no)"
	read count
	case $count in
		yes) busy=`expr $busy + 1`;;
		no) continue;;
	esac
done
echo "$busy日忙しいようです。"
