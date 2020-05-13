#!/usr/bin/bash

count=0

for day in 月 火 水 木 金 土 日
do
  read -p "$day曜日は忙しい日でしたか？(yes / no):" yes_no
  if [ $yes_no = "yes" ]; then
    let count++
  fi
done

echo "一週間のうち$count日忙しかった"

