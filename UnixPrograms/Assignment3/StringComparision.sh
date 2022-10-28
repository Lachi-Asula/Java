read -p "Enter First String: " str1
read -p "Enter Second String: " str2
if [ $str1 = $str2 ]; then
	echo "Two Strings are Equal"
else
	echo "Two Strings are Different"
fi

