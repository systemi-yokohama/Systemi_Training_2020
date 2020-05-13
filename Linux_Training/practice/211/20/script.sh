#!/usr/bin/bash

read -p "INPUT" num

if [ $num -lt "100" ]; then
	echo "100未満です"
elif [ $num -ge "1000" ]; then
	echo "1000以上です"
else
	echo "100以上1000未満です"
fi

