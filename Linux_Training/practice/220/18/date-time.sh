#!/usr/bin/bash

time=$(date '+%H')
if [ $time -le 12 ]; then
	echo 午前
else
	echo 午後
fi
