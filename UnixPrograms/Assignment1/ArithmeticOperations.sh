until [ $true ];
do
	echo "Menu"
        echo "1. Addition"
        echo "2. Subtraction"
        echo "3. Division"
        echo "4. Multiplication"
        echo "5. Exit"
        echo
        read -p "Choose any Arithmetic operation: " opt
        case $opt in
                1)echo "Addition" 
		read -p "Enter First Value: " a
                read -p "Enter Second value: " b
                 echo "Sum: `expr $a + $b` "
                ;;

                2)echo "Subtraction"
		read -p "Enter First value: " a
                read -p "Enter Second value: " b
                echo "Subtraction: `expr $a - $b`"
                ;;

                3)echo "Division"
		read -p "Enter First Value: " a
                read -p "Enter Second value: " b
                echo "Division:`expr $a / $b`"
                ;;

                4)echo "Multiplication"
		read -p "Enter First value: " a
                read -p "Enter Second value: " b
                echo "Multiplication: `expr $a \* $b`"
                ;;

                5)exit 0
                ;;

                *)
                echo "Invalid Option"
                ;;
        esac
done

