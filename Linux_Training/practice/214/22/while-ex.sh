#!/usr/bin/bash

#５から１まで順に表示していくスクリプトを作成せよ。

var=5
until [ "$var" -eq "0" ]
do
	echo "$var"
	let var--
done
