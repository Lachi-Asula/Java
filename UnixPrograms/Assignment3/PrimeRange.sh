read -p "Enter firstNum To calculate Prime numbers upto range: " firstNum
read -p "Enter LastNum To calculate Prime numbers upto range: " lastNum
echo "Prime Numbers are: "
for (( i=$firstNum; i <= $lastNum; i++ ))
do
	for (( j=2; j < $i; j++ ))
	do
		b=true
		if [ `expr $i % $j` = 0 ];then
			b=false
			break;
		fi
	done
	if $b; then
		result+=" $i "
	fi
done
echo $result
