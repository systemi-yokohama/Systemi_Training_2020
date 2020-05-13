#!/usr/bin.bash

i=5

until [ $i -lt "1" ]
do
	echo $i
	i=`expr $i - 1`	
done

