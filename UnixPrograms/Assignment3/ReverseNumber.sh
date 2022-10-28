read -p "Enter any number to perform reverse operation: " num
sum=0
while [ $num -gt 0 ]
do
	rem=`expr $num % 10`
	sum=`expr $sum \* 10 + $rem`
	num=`expr $num / 10`
done
echo "Reverse of Given Number is: " $sum
