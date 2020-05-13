#!/usr/bin/bash

echo "数値を入力"
read num

if [ $num -lt "100" ]; then
	  echo "100未満です"
  elif [ $num -ge "100" ] && [ $num -lt "1000" ]; then
	    echo "100以上1000未満です"
    elif [ $num -ge "1000" ]; then
	      echo "1000以上です"
fi
