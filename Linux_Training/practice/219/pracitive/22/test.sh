#!/usr/bin/bash

c=5
until [ $c -eq "0" ]; do
	echo $c
	c=`expr $c - 1`
done
