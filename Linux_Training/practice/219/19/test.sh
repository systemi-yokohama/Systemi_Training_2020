#!/usr/bin/bash
day=0
for i in "月" "火" "水" "木" "金" "土" "日";do

	echo "$i曜日は忙しいですか？（yes/no）"
	read a
	case $a in
		yes) day=`expr $day + 1`;;
		no) continue;;
	esac

done
echo "$day日、忙しい日がありました。"
