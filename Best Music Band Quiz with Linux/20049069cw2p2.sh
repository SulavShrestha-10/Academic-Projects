#!/bin/bash
#Validating the first and second parameter in the program while executing it.
if ! [[ $1 =~ [Aa-Zz]+$ && $2 =~ ^[0-9]+$ ]]
then
        echo -e "The first parameter should be in alphabets.\nThe second parameter should be in digits."
	exit
fi
#Declaring a variable 
secret_key=2768
n=3
#Using loop to iterate more than once
while [ $n -ge 1 ]
do
	echo -e "Enter the secret key: \c"
	read -s key
	if [ $key == $secret_key ]
	then
		break
	else
		echo -e "\nIncorrect Key Entered!!!\nTry Again."
	fi
	(( n-- ))
	if [ $n -lt 1 ]
	then
		echo -e "Incorrect key enetered three times!!!\nThe program will now close!" 
		exit
	fi
done
#Using echo command to print some information
echo -e "\n"
echo "-------------------"
echo "WELCOME!!"
echo "-------------------"
echo "ID: $2"
echo "Name: $1"
echo -e "Date: \c" 
date +"%m-%d-%Y"
echo -e "Time: \c" 
date +"%r"
echo "-------------------"
#Creating a function for repeating the program.
RepeatFunc() {
	echo -e "Do you wish to continue?(Y/N) \c"
	read cont
	case $cont in
	Y|y) BandFunc ;;
	N|n) echo "Thank you!!"
		exit ;;
	*) echo "Enter Y/N or y/n!!" 
		RepeatFunc ;;
	esac
}
#Creating a prgram to select a band member from the particualr list
SelectFunc() {
        PS3="Please select one option from the given list:"
        select mem in ${arr[@]}
        do
		case $mem in
			JL) cat JL ;;
			FM) cat FM ;;
			AY) cat AY ;;
			KC|DH) echo The information about the selected member is currently not available. Please choose again.
				SelectFunc;;
			*) echo Chose from the given options.
			    	SelectFunc ;;
		esac
		break
        done
        RepeatFunc
}
#Creating a function to select 3 member from the table.
MemberFunc() {
#Displaying the table using echo command
	echo "-------------------------------"
	echo "|Member Name    |  Member Code|"
	echo "-------------------------------"
	echo "|John Lennon    |  JL         |"
	echo "|Angus Young    |  AY         |"
	echo "|Fredie Mercury |  FM         |"
	echo "|Debby Harry    |  DH         |"
	echo "|Kurt Cobain    |  KC         |"
	echo "-------------------------------"
	echo -e "The given names are the star band members from the above mentioned bands.\nEnter the member code of three star band member from the given list."
#Using loop to iterate until the user choses the correct options.	
	while true
	do
		echo -e "Member codes: \c"
        	read mem1 mem2 mem3
        	#Using array to store the inputs given by the user.
		arr=($mem1 $mem2 $mem3)
		if [ -z arr ]
		then
			echo Please enter the codes.
			MemberFunc
		elif [ ${#arr[@]} -ne 3 ]
		then
			echo You are required to enter three member codes.
			MemberFunc
		elif [ $mem1 == $mem2 ] || [ $mem1 == $mem3 ] || [ $mem2 == $mem3 ]
		then
			echo You are required to select unique member codes from the given options.
			MemberFunc
		else
			for n in ${arr[@]}
			do
				if  [ $n == "JL" ] || [ $n == "AY" ] || [ $n == "FM" ] || [ $n == "DH" ] || [ $n == "KC" ]
				then
					continue
				elif ! [[ $n =~ [A-Z] ]]
				then
					echo You are required to use capital letters.
					MemberFunc
				else
					echo You are allowed to select from the given codes only.
					MemberFunc
				fi
			done
		fi
		break
	done
	#Calling the SelectFunc function
	SelectFunc
}
#Creating a function to select a best band
BandFunc() {
        echo "--------------------------"
        echo "|Band Name   |  Band Code|"
        echo "--------------------------"
        echo "|Beatles     |  BEA      |"
        echo "|AC/DC       |  AD       |"
        echo "|Queen       |  QUE      |"
        echo "|Blondie     |  BLO      |"
        echo "|Nirvana     |  NIR      |"
        echo "--------------------------"
	correct=n
	echo -e "Can you guess which is the best music band from the given options?\nUse the band code to choose one of the options."
	echo -e "Your guess: \c"
	read guess
	#Using loop to iterate until the user guesses the correct option
	until [ $correct == "y" ]
	do
		if [ $guess == "BEA" ]
		then
			echo -e "You have guessed it right.\n"
			echo -e "BEATLES\nBeatles is an English rock band compromising of John Lennon, Paul McCartney, George Harrison and Ringo Starr.\nThey are considered as one of the most influential band of all time for their contribution in development of pop music as an art form.\n"
			correct=y
		elif ! [[ $guess =~ [A-Z] ]]
		then
			echo -e "You are required to use capital letters here.\nGuess again: \c"
			read guess
		else
			echo -e "You have guessed it wrong.\nGuess again: \c"
			read guess
		fi
	done
	MemberFunc
}
BandFunc

