#!/usr/bin/bash


LIMIT=`date "+%H"`

if [ $LIMIT -lt 12  ]; then
  echo "午前です"
else
  echo "午後です"
fi
