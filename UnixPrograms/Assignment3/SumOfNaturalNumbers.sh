read -p "Enter Nth number to calculate Sum of Natural numbers: " num
sum=0
for (( i=1; i <= $num; i++ ))
do
	sum=`expr $sum + $i`
done
echo "Sum  of Natural Numbers upto $num is : $sum"

