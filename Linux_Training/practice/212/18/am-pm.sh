#!/usr/bin/bash

#hourはdateのうちの現在時刻のみを抽出する変数
hour='date + "%h"'

if [$hour -lt "12"];then
echo "午前です"
else
echo "午後です"
fi


