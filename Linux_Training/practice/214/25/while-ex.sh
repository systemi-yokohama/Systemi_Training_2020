#!/usr/bin/bash

while :
do
	echo "四則演算を選択　1)加算 2)減算 3)乗算 4)除算 5)終了する"
	read formula
	case $formula in 
			
		1)
			echo "加算"
			echo "値①："
			read num1
			echo "値②："
			read num2
			answer=$(( $num1 + $num2 ))
			echo "$answer"
			;;
	        2)
			echo "減算"
			echo "値①："
			read num1
			echo "値②："
			read num2
			answer=$(( $num1 - $num2 ))
			echo "$answer"
			;;
		3)
			echo "乗算"
			echo "値①："
			read num1
			echo "値②："
			read num2
			answer=$(( $num1 * $num2 ))
			echo "$answer"
			;;
		1)
			echo "加算"
			echo "値①："
			read num1
			echo "値②："
			read num2
			answer=$(( $num1 / $num2 ))
			echo "$answer"
			;;
		5) break;;
	esac
done
echo "四則演算を終了します"
