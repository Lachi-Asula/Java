read -p "Enter any Number to check Prime or Not: " num
b=true
for (( i=2; i < $num; i++ ))
do
	if [ `expr $num % $i` = 0 ]; then
		b=false
		break
	fi
done
if $b; then
	echo "Given Number is a Prime"
else
	echo "Given Number is not a Prime"
fi
