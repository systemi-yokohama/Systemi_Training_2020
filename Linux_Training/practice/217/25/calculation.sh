#!/usr/bin/bash

while :
do
	echo "1.足し算 2.引き算 3.掛け算 4.割り算 5.exit"
	read calc
	case $calc in
		1) 
		echo "最初の数字を入力"
		read a
		echo "次の数字を入力"
		read b
		c=`expr $a + $b`
		echo "計算結果は $c "
		;;

		2) 
		echo "最初の数字を入力"
		read a
		echo "次の数字を入力"
		read b
		c=`expr $a - $b`
		echo "計算結果は $c "
		;;

		3) 
		echo "最初の数字を入力"
		read a
		echo "次の数字を入力"
		read b
		c=`expr $a \* $b`
		echo "計算結果は $c "
		;;
		4) 
		echo "最初の数字を入力"
		read a
		echo "次の数字を入力"
		read b
		c=`expr $a / $b`
		echo "計算結果は $c "
		;;
		5) break;;
	esac
done

