#!/usr/bin/bash

declare -i COUNTER
COUNTER=5

until [ $COUNTER -eq 0 ]
do
	echo $COUNTER
	let COUNTER--

done
