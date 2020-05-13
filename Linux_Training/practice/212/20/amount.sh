#!/usr/bin/bash

ehco "数を入力してください"
read number
if [$number -lt "100"];then
echo "100未満です"
elif[$num -ge "100"]&&[$num -lt "1000"];then
echo "100以上1000未満です"
else
echo "1000以上です"
fi

