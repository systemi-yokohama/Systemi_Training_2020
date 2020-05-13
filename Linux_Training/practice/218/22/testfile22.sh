#!/usr/bin/bash

count=5
until [ $count -eq "0" ]; do
       	echo $count
       	count=`expr $count - 1`
done
