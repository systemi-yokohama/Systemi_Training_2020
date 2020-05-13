#!/usr/bin/bash

read -p "数字を入力:" number

if [ $number -lt 100 ]; then
  echo "100未満です"
elif [ $number -ge 100 -a $number -lt 1000 ];then
  echo "100以上1000未満です"
else
  echo "1000以上です"
fi

