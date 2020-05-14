#!/usr/bin/bash

time=`date "+%H"`
if [ $time -lt "12" ]; then
	  echo "午前"
elif [ $time -ge "12" ]; then
	  echo "午後"
fi

