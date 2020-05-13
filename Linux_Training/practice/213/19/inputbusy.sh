#!/usr/bin/bash

busyday=0

for week in 月 火 水 木 金 土 日;
do
	echo "$week曜日は忙しかったですか? (yes / no)"
	read busy

	case $busy in
		yes) busyday=`expr $busyday + 1`;;
		no) continue;;
	esac
done
echo "$busyday日、忙しかったです"

