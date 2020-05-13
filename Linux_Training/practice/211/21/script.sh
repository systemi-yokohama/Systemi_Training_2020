#!/usr/bin/bash

read -p "number:" num

if [ $num -gt "5" ]; then
	while [ $num -ge "5" ]
	do
		echo "$num"
		num=`expr $num - 1`
	done
else
	echo "error"
fi

