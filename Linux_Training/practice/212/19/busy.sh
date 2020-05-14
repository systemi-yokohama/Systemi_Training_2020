#!/usr/bin/bash

#１週間の間で何日忙しいか表示させるスクリプト
busyday=0
for week in 月　火　水　木　金　土　日
do
echo "$week曜日は忙しかったですか？（yes/no）"
read busy
case $busy in
	yes)busyday=`expr $busyday + 1`;;
	no)continue;;
esac

done
echo "１週間のうち、$busyday日忙しかった。"

