#!/usr/bin/bash

declare -i COUNTER
COUNTER=0

for i in 月 火 水 木 金 土 日
do
read -p "$i曜日は忙しかったか?yes/no：" BUSY
case $BUSY in 
"yes" ) let COUNTER++;;
esac
done
echo "$COUNTER日間忙しかった"
