#!/usr/bin/bash
COUNTER=5
until [ "$COUNTER" -lt "1" ]
do
	echo "$COUNTER"
	let COUNTER--
done

