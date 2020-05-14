#!/usr/bin/bash

while :
do
  echo "どの演算をしたいか選んでね　1)加算　2)減算　3)乗算　4)除算　5)終了"
  read calc

  case $calc in
  1)
    echo "加算を始めます"
    echo "最初の値を入力"
    read num1
    echo "次の値を入力"
    read num2
    answer=`expr $num1 + $num2`
    echo "$num1 + $num2 = $answer です"
  ;;
  2)
    echo "減算を始めます"
    echo "最初の値を入力"
    read num1
    echo "次の値を入力"
    read num2
    answer=`expr $num1 + $num2`
    echo "$num1 + $num2 = $"

