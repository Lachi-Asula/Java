read -p "Enter String to perform reverse operation: " str
len=${#str}
rev=""
for (( i=$len - 1; i >= 0; i-- ))
do
        rev+=${str:$i:1}
done
if [ $str = $rev ]; then
	echo "Given String is Palindrome"
else
	echo "Given String is Not a Palindrome"
fi

