import Date
import Lists

def borrow():
    IsBorrowed=False
    #Using while loop to ask user for input
    while(True):
        FirstName=input("Enter your first name: ")
        if FirstName.isalpha():
            break
        print("Enter your name properly!")
    while(True):
        LastName=input("Enter your last name: ")
        if LastName.isalpha():
            break
        print("Enter your name properly!")
        print("\n")
        
    record="Borrower "+FirstName+".txt"
    f=open(record,"w+")#Opening file in read and write mode
    #writing the below information
    f.write("\t\t     The Library Management System\n")
    f.write("\t\t\t   Borrower Details\n\n\n")
    f.write("Borrowed by: "+FirstName+ " "+LastName+ "\n")
    #Use of date and time module to get date and time
    f.write("Borrow Date: "+Date.date()+"\n")
    f.write("Borrow Time: "+Date.time()+"\n\n")
    f.write("|-----------------------------------------------------------------------|\n")
    f.write("|S.N.\t|\tName of the Book\t|Author\t\t|\tPrice   |\n")
    f.write("|-----------------------------------------------------------------------|\n")
    f.close()
    #Using while loop
    total=0
    while IsBorrowed==False:
        print("Enter an number from below to borrow a book: ")
        #Using for loop
        for i in range(4):
            print("Press",i,"To borrow book", Lists.Books[i])   
        try:
            #Asking the user input
            num=int(input("Enter the number:"))
            if num<0:
                print("Do not enter negative numbers!\n")
            else:
                try:
                    #using if block to check the availability of the books
                    if(int(Lists.Quantity[num])>0):
                        print("The book is available.")
                        f=open(record,"a")#Opening file in append mode
                        f.write("|1.\t|\t"+Lists.Books[num]+"\t\t|"+Lists.Author[num]+"\t|\t"+"$"+Lists.Price[num]+"\t|\n")
                        f.close()
                        Lists.Quantity[num]=int(Lists.Quantity[num])-1
                        total=total+int(Lists.Price[num])
                        #Opening the file in read and write mode
                        f=open("Library.txt","w+")
                        #Using for loop to change the values in the text file
                        for i in range(4):
                            f.write(Lists.Books[i]+","+Lists.Author[i]+","+str(Lists.Quantity[i])+","+"$"+Lists.Price[i]+"\n")
                        f.close()
                        #using loop for borrowing multiple books
                        multiple=False
                        count=1
                        while multiple==False:
                            #Asking the user to input a value
                            Ask=input("Do you want to borrow another book? Type[Y/N]").upper()
                            if(Ask=="Y"):
                                print("Enter an number from below to borrow a book: ")
                                for i in range(4):
                                    print("Press",i,"To borrow book",Lists.Books[i]) 
                                try:
                                    #Asking the user for input
                                    check=int(input("Enter the number:"))
                                    if check==num:
                                        print("You cannot borrow the same book twice.")   
                                    else:
                                        try:
                                            #using if else statement
                                            if(int(Lists.Quantity[check])>0):
                                                print("The book is available")
                                                count=count+1
                                                f=open(record,"a")#Opening file in append mode
                                                #Changing the values in the text file
                                                f.write("|"+str(count)+"."+"\t|\t"+Lists.Books[check]+"\t\t|"+Lists.Author[check]+"\t|\t"+"$"+Lists.Price[check]+"\t|\n")
                                                f.close()
                                                #Decreasing the quantity
                                                Lists.Quantity[check]=int(Lists.Quantity[check])-1
                                                total=total+int(Lists.Price[check])
                                                #Using for loop to change the values in the text file
                                                f=open("Library.txt","w+")
                                                for i in range(4):
                                                    f.write(Lists.Books[i]+","+Lists.Author[i]+","+str(Lists.Quantity[i])+","+"$"+Lists.Price[i]+"\n")
                                                f.close()
                                            else:
                                                print("The book is not available at the moment.")
                                        #use of the except block
                                        except IndexError:
                                            print("Choose the books according to their number!\n")
                                except ValueError:
                                    print("Choose as suggested!\n")  
                            elif(Ask=="N"):
                                print("Thank you for borrowing books from us.\n\n")
                                multiple=True
                                IsBorrowed=True
                            else:
                                print("Invalid!\nType Y for Yes and N for No.")
                    else:
                        print("The book is not available at the moment.")
                    if total>0:
                        f=open(record,"a")
                        f.write("|-----------------------------------------------------------------------|\n")
                        f.write("|\t\t\t\t\t\t\t  Total:$"+str(total)+"\t|\n")
                        f.write("|-----------------------------------------------------------------------|\n")
                        f.close()
                #Use of the except block                        
                except IndexError:
                    print("Choose the books according to their number!\n")
        except ValueError:
            print("Choose as suggested!\n")
    print("The Borrower Details:")
    #Printing the text file in the shell
    f=open(record,"r")
    data=f.read()
    print(data)
    f.close()
                   
