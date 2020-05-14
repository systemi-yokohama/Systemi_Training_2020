#!/usr/bin/bash

COUNTER=5
until [ "$COUNTER" -eq '0' ]
do
	echo "$COUNTER"
	let COUNTER--
done
