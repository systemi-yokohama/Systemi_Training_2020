#/usr/bin/bash

while :
do
	echo "四則演算　1）加算 2）減算 3）乗算 4）除算 5）終了"
	read clac

	case $clac in
		1)
			echo "加算を始めます"
			echo "最初の値を入力"
			read num1
			echo "次の値を入力"
			read num2
			answer=`expr $num1 + $num2`
			echo "$num1 + $num2 = $answerです";;

		2)
			echo "減算を始めます"
			echo "最初の値を入力"
			read num1
			echo "次の値を入力"
			read num2
			answer=`expr $num1 + $num2`
			echo "$num1 - $num2 = $answerです";;

		3)
			echo "乗算を始めます"
			echo "最初の値を入力"
			read num1
			echo "次の値を入力"
			read num2
			answer=`expr $num1 + $num2`
			echo "$num1 * $num2 = $answerです";;

		4)
			echo "除算を始めます"
			echo "最初の値を入力"
			read num1
			echo "次の値を入力"
			read num2
			answer=`expr $num1 + $num2`
			echo "$num1 / $num2 = $answerです";;
		5)
			break;;
	esac
done

echo "終了しました"
			
