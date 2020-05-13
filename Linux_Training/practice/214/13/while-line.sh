#!/usr/bin/bash

#cat /etc/hosts

while read content

do
	echo "$content"

done < /etc/hosts

