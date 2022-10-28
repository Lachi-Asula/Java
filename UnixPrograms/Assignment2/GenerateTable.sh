read -p "Enter a Number for displaying Table : " num
echo
echo "Multiplication table for $num is: "
for (( i=1; i <= 10; i++ ))
do
	echo "$num * $i = `expr $num \* $i`"

done
