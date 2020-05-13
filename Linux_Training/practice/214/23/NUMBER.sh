#!/usr/bin/bash

 
ANS=$((RAMDOM%+11))


while  :
do

echo "0~10のいずれかを入力してください"
read NUM

  if [ $NUM -eq $ANS ]; then
 	echo "正解"
	break
  elif [ $NUM -gt $ANS ]; then
	echo "もっと小さい"
  elif [ $NUM -lt $ANS ]; then
	echo "もっと大きい"
  fi
done
