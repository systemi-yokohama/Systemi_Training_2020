#!/usr/bin/bash

input () {
  read -p "計算したい2つの数字を入力してください：" num1 num2
}

select result in 加算 減算 乗算 除算 exit
do
  if [ $result = "加算" ]; then
    input
    echo "$num1 + $num2 = $(( $num1 + $num2 ))"
  elif [ $result = "減算" ]; then
    input
    echo "$num1 - $num2 = $(( $num1 - $num2 ))"
  elif [ $result = "乗算" ]; then
    input
    echo "$num1 * $num2 = $(( $num1 * $num2 ))"
  elif [ $result = "除算" ]; then
    input
    echo "$num1 / $num2 = $(( $num1 / $num2 ))"
  else
    echo "終了"
    break
  fi
done
