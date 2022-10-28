num=5
for (( i=1;i <= 10; i++ ))
do

	num1=`expr $num \* $i`
	series+=$i","$num1","
done
echo "Series is: " $series
