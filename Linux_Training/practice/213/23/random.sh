#usr/bin/bash

number=`expr $RANDOM % 10`

while :
do
	echo "0～9の数値を入力してください"
	read inputNumber

	if [ $inputNumber -eq $number ]; then
		echo "あたり"
		break
	elif [ $inputNumber -gt $number ]; then
		echo "$inputNumberより小さい"
	elif [ $inputNumber -lt $number ]; then
		echo "$inputNumberより大きい"
	fi
done
