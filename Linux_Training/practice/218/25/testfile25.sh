#!/usr/bin/bash

while :
do
  echo 四足演算　1 加算 ,2 減算 ,3 乗算 ,4 除算 ,5 終了
  read calc
  
  case $calc in
	  1 ) echo 加算します
	      echo 一つ目の値を入力してください
	      read num1
	      echo 二つ目の値を入力してください
	      read num2
	      ans=`expr $num1 + $num2`
	      echo $num1 + $num2 = $ans
	    ;;
	  2 ) echo 減算します
	      echo 一つ目の値を入力してください
	      read num1
	      echo 二つ目の値を入力してください
	      read num2
	      ans=`expr $num1 - $num2`
	      echo $num1 - $num2 = $ans
	    ;;
	  3 ) echo 乗算します 
	　　　echo 一つ目の値を入力してください
	      read num1
	      echo 二つ目の値を入力してください
	      read num2
	      ans=`expr $num1 * $num2`
	      echo $num1 * $num2 = $ans
	    ;;
	  4 ) echo 除算します
	　　　echo 一つ目の値を入力してください
	　　　read num1
	      echo 二つ目の値を入力してください
	      read num2
	      ans=`expr $num1 / $num2`
	      echo $num1 / $num2 = $ans
            ;;
	  5 ) break
            ;;
   esac
done
echo 終了
