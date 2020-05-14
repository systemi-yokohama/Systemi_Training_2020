#!/usr/bin/bash

var=0
#まず月～日曜日まで忙しいか聞いていく。
#忙しい[y]なら忙しいにインクリ、忙しくないなら[n]、忙しくないにインクリ

for week in 月 火 水 木 金 土 日; do

	echo "$week曜日は忙しかったですか(yes/no)"
	read busy

	case $busy in
		yes) var=`expr $var + 1`;;
		no) continue;;
	esac
done

echo $var日忙しいです
