declare -a arr
read -p "Enter size of an Array : " len
echo "Enter elements into array :"
for (( i=0; i < $len; i++ ))
do
        read arr[$i]
done

ascendingOrder(){
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
	echo "Ascending Order is: "
	echo ${arr[*]}
}

descendingOrder(){
  	for (( i=0; i < $len; i++ ))
        do
                for (( j=`expr $i + 1`; j < $len; j++ ))
                do
                        if [ ${arr[i]} -lt ${arr[j]} ]; then
                                temp=${arr[i]}
                                arr[$i]=${arr[j]}
                                arr[$j]=$temp
                        fi
                done
        done
	echo "Descending Order is: "
	echo ${arr[*]}
}

echo "Sorting Orders"
echo "1. Ascending Order"
echo "2. Descending Order"
echo "3. exit"
read -p "Select any Option: " opt
case $opt in
        1) ascendingOrder
                ;;
        2) descendingOrder
                ;;
        3) exit 0
                ;;
        *) echo "Invalid Option"
esac

