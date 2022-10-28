temp=0
echo "Enter the range For Multiplication table : "
until [ $false ];
do
	read -p "Enter First value : " first
	read -p "Enter Last value : " last
	if [ $first -eq $first -a $last -eq $last ] 2>error.txt
	then
		if [ $first -gt $last -o $first -eq $last ]; then
			echo "First value should be less than last value"
		elif [ $first -lt 0 -o $first -eq 0 ];then
			echo "Values must not be Zero or negative"
		else
			break;
		fi
	else
		echo "error: Enter only Integer values"	
	fi
done
for (( i=$first; i <= $last; i++ ))
do
	echo "$i Multiplication table is"
	for (( j=1; j <= 10; j++ ))
	do
		echo "$i * $j : `expr $i \* $j`"
	done
	echo
done

