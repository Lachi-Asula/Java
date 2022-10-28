read -p "Enter First file name: " file1
read -p "Enter Second file name: " file2
echo
echo "Concatecation of file1 and file2 information is stored into file3"
echo
cat file1 file2 > file3
echo "File3 information is: "
echo
cat file3
