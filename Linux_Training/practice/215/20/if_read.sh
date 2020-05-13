#!/usr/bin/bash
echo "値を入力"
read i
if [ $i -lt 100 ];then
echo “100未満です”
elif [ $i -ge 100 -a $i -lt 1000 ];then
echo “100以上1000未満です”
else
echo “1000以上です”
fi

