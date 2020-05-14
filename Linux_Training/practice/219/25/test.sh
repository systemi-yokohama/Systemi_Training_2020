#!/usr/bin/bash
echo "１．加法　２．減法　３．乗法　４．除法"
read i
case $i in
	1)
		echo "値１を入力してください"
		read n1
		echo "値２を入力してください"
		read n2
		n=`expr $n1 + $n2`
		echo "結果は $n です";;
	2)
		echo "値１を入力してください"
		read n1
		echo "値２を入力してください"
		read n2
		n=`expr $n1 - $n2`
		echo "結果は $n です";;
	3)

		echo "値１を入力してください"
		read n1
		echo "値２を入力してください"
		read n2
		n=`expr $n1 * $n2`
		echo "結果は $n です";;
	4)
		echo "値１を入力してください"
		read n1
		echo "値２を入力してください"
		read n2
		n=`expr $n1 / $n2`
		echo "結果は $n です";;
esac
