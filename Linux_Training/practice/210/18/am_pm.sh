#!/usr/bin/bash


if [ `date "+%p"` = "午前" ]; then
  echo 現在は午前です
else
  echo 現在は午後です
fi
