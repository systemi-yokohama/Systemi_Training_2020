#!/usr/bin/bash

time=`date "+%H"`

if [ $time -lt "12" ]; then
	echo "午前です"
else
	echo "午後です"
fi

