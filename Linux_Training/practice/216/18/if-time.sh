#!/usr/bin/bash

time=`date "+%H"`

if [  $time -ge 12 ]; then
	echo PM
else
	echo AM
fi


