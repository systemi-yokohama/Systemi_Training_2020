#!/usr/bin/bash

echo "5以上の数字を入力してください"
read number

if [$number -ge "5"];then
while [$number -ge "5"]; do
echo "$number"
number=`expr $number - 1`
done
else
echo "5以上の数字ではありません"
fi

