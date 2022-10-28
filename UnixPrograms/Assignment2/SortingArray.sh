declare -a arr
read -p "Enter size of an Array : " len
echo "Enter elements into array :"
for (( i=0; i < $len; i++ ))
do
        read arr[$i]
done
for (( i=0; i < $len; i++ ))
do
        for (( j=`expr $i + 1`; j < $len; j++ ))
        do
                if [ ${arr[i]} -gt ${arr[j]} ]; then
                        temp=${arr[i]}
                        arr[$i]=${arr[j]}
                        arr[$j]=$temp
                fi
        done
done
echo "Sorted array is : ${arr[*]}"
echo
echo "Biggest Number is : ${arr[`expr $len - 1`]}"
echo "Smallest Number is : ${arr[0]}"


