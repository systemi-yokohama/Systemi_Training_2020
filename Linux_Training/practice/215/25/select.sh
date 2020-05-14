#!/usr/bin/bash

echo "数値１を入力："
read num1
echo "数値２を入力："
read num2

echo "1 ) 足し算" 
echo "2 ) 引き算" 
echo "3 ) 掛け算"
echo "4 ) 割り算"
echo "5 ) 余り"
echo "6 ) 終了"

while :
do
	read -p: VAR 
	case "$VAR" in
		1 ) echo $(($num1 + $num2)) ;;
		2 ) echo $(($num1 - $num2)) ;;
		3 ) echo $(($num1 * $num2)) ;;
		4 ) echo $(($num1 / $num2)) ;;
		5 ) echo $(($num1 % $num2)) ;;
		6 ) break ;;
	esac
done
