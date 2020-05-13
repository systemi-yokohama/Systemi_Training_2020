#!/usr/bin/bash

count=0

for i in 月曜日 火曜日 水曜日 木曜日 金曜日 土曜日 日曜日;do
echo "$iは忙しいか？"
read busy
case $busy in 
	yes ) count=`expr $count + 1`;;
	no ) continue;;
esac
done

echo "$count日忙しい。"
