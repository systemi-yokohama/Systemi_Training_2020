#!/usr/bin/bash

hour=`date "+%H"`

if [ $hour -lt 12 ]; then
	echo "午前です"
elif [ $hour -ge 12 ]; then
	echo "午後です"
fi
