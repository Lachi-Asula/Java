declare -a strArray
read -p "Enter how many strings you want to concatenate: " range
echo "Enter Strings: "
for (( i=0; i < $range; i++ ))
do
	read strArray[$i]
	if [ ${strArray[i]} -eq ${strArray[i]} ] 2>error.txt
	then
		echo "Enter String type values only"
		i=`expr $i - 1`
	else
		result+=${strArray[i]}
	fi
done
echo "Concatenation of All the Given Strings is: "
echo $result
