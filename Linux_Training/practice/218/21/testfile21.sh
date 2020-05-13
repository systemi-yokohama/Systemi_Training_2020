#!/usr/bin/bash

echo -n 数字を入力してください:
read str
if [ $str -ge 5 ]; then
  while :
  do
  echo $str
  let str--
  if [ $str -lt 5 ]; then
	break
  fi
  done
else
	echo 5以上の数字を入れてください
fi
