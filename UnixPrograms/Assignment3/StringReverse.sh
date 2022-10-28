read -p "Enter String to perform reverse operation: " str
len=${#str}
rev=""
for (( i=$len - 1; i >= 0; i-- ))
do
	rev+=${str:$i:1}
done
echo "Reverse of the Given String is: $rev"
