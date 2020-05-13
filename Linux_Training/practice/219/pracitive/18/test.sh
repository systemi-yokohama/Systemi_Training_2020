#!/usr/bin/bash

T=`date +%H`
if [ $T -lt 12 ]
then
	echo "午前"
else
	echo "午後"
fi
