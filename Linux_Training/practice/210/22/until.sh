#!/usr/bin/bash

count=5

until [ $count -eq 0 ]
do 
  echo $count
  let count--
done
