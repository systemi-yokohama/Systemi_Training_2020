#!/usr/bin/bash

num=$(( $RANDOM % 6 ))

while :
do
  read -p "1から5の数字：" number

  if [ $num -eq $number ]; then
    echo "正解です"
    break
  elif [ $num -gt $number ]; then
    echo "乱数より小さいです"
  else
    echo "乱数より大きいです"
  fi
done
