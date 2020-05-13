#!/usr/bin/bash

conut=0
echo yesかnoで答えてください
for i in 日曜日 月曜日 火曜日 水曜日 木曜日 金曜日 土曜日
do
echo $iは忙しかったか
read str
if
       [ $str = "yes" ]; then
              count=`expr $count + 1`
fi
done
echo 忙しい日は$count日間ありました
