until [ $true ]
do
	read -p "Enter a number to calculate the factorial : " num
	if [ $num -eq $num ] 2>error.txt 
	then
		if [ $num = 0 ]; then
			num=1
		fi
		break;
	else
		echo "error: Enter Integer Values only"
	fi
done
for (( i=$num - 1; i > 1; i-- ))
do
	num=`expr $num \* $i`
done
echo
echo "Factorial of The given number is : $num"
