import Lists
import Date

def Return():

    #Asking user to input value
    Name=input("Enter your first name:")
    text="Borrower "+Name+".txt"
    print("")
    #Using try block to look for errors
    try:
        f=open(text,"r")
        info=f.read()
        print(info)
    #Using the except block when a error occurs
    except:
        print("The name of the borrower does not match.")
        Return()
    store="Returner "+Name+".txt"
    f=open(store,"w+")#read and write text file
    f.write("\t\t\tThe Library Management System\n")
    f.write("\t\t\t       Returner Details\n\n\n")
    f.write("Returned by: "+Name+"\n")
    #Using the datetime function of Date module
    f.write("Return Date: "+Date.date()+"\n")
    f.write("Return Time: "+Date.time()+"\n\n")
    f.write("|-----------------------------------------------------------------------------|\n")
    f.write("|S.N.\t|\tName of the Book\t|\tAuthor\t\t|\tPrice |\n")
    f.write("|-----------------------------------------------------------------------------|\n")
    f.close()
    #Initializing cost and count
    cost=0
    count=0
    
    #using for loop to add elements in the text file
    for i in range(4):
        if Lists.Books[i] in info:
            count+=1
            f=open(store,"a")#Using the text file in append mode
            #Using the Lists module to write inside the text file
            f.write("|"+str(count)+"."+"\t|\t"+Lists.Books[i]+"\t\t|\t"+Lists.Author[i]+"\t|\t"+"$"+Lists.Price[i]+"    |\n")
            f.close()
            #Increasing the quantity
            Lists.Quantity[i]=int(Lists.Quantity[i])+1
            cost=cost+int(Lists.Price[i])           
    f=open(store,"a")
    f.write("|-----------------------------------------------------------------------------|\n")
    f.write("|\t\t\t\t\t\t\t\t|Total: $"+str(cost)+"    |\n")
    f.close
    #Initializing two boolean values
    Ask=False
    isLate=False
    while Ask==False:
        #Asking the user for input
        check=input("Is the book being given back late? Type[Y/N]: ").upper()
        while isLate==False:
            #Using if else function
            if check=="Y":
                days=int(input("Enter the number of days of returning the book late: "))
                if days>=1:
                    fine=2*days
                    cost=cost+fine
                    f=open(store,"a")
                    f.write("|-----------------------------------------------------------------------------|\n")
                    f.write("|\t\t\t\t\t\t\t\t| Fine: $"+str(fine)+"    |\n")
                    f.write("|-----------------------------------------------------------------------------|\n")
                    f.write("|\t\t\t\t\t\t\tTotal with fine:$"+str(cost)+"   |\n")
                    f.close()
                Ask=True
                isLate=True
            elif check=="N":
                print("Thank you for returning the book.")
                Ask=True
                isLate=True
            else:
                print("Enter a valid option!")
                break
            #Opening the text file in read and write mode
            f=open("Library.txt","w+")
            #Using for loop to change the values in text file
            for i in range(4):
                f.write(Lists.Books[i]+","+Lists.Author[i]+","+str(Lists.Quantity[i])+","+"$"+Lists.Price[i]+"\n")
            f.close()
    f=open(store,"a")
    f.write("|-----------------------------------------------------------------------------|\n")
    f.close()
    print("Thank you for returning the book.")
    print("")
    print("The Returner Details:")
    #Printing the text file in the shell
    f=open(store,"r")
    info=f.read()
    print(info)
    f.close()
    

