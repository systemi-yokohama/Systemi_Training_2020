#!/usr/bin/bash

number=`expr $RANDOM % 10`
echo "同じ数値になるまで繰り返します"

while :
do
  echo "0～9の数値を入力してください"
  read inputNumber

  if [$inputNumber -eq $number]; then
    echo "一致しました"
    break
  elif [$inputNumber -gt $number]; then
    echo "少し小さい"
  elif [$inputNumber -lt $number]; then
    echo "少し大きい"
  fi
done

