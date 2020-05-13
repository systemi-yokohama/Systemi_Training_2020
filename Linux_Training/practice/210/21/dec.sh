#!/usr/bin/bash

read -p "5以上の数字:" number

if [ $number -ge 5 ]; then
  while [ $number -ge 5 ]
  do
    echo $number
    let number--
  done
    echo "終了"
else
  echo "エラー：5以上の数字を入力してください"
fi
