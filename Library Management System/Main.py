import ReturnBook
import BorrowBook
import Lists
import Date

def main():
    loop=True
    while(loop==True):
        #printing the given information
        print("Welcome to our Library Management System")
        print("----------------------------------------")
        print(" Press 1: To Display Books")
        print(" Press 2: To Borrow Books")
        print(" Press 3: To Return Books")
        print(" Press 4: To Exit Library")
        print("----------------------------------------")
        #Using the try block to look for errors
        try:
            ##Asking user to enter a number
            id=int(input("Enter a number from 1-4:"))
            
            #Using the if and else to do certain tasks when respective conditions are met
            if(id==1):
                #Displaying the books available
                Lists.lists()
                print("\nWe have the following books available in our library:")
                print("|-----------------------------------------------------------------------|")
                print("|Book Name\t|\tAuthor Name\t|\tQuantity|\tPrice\t|")
                print("|-----------------------------------------------------------------------|")
                f=open("Library.txt","r")
                for i in range(4):
                    print("|"+Lists.Books[i]+"\t|\t"+Lists.Author[i]+"\t|\t"+str(Lists.Quantity[i])+"\t|\t$"+str(Lists.Price[i])+"\t|")
                print("|-----------------------------------------------------------------------|")
                f.close()
                print("\n")
            elif(id==2):
                #Calling functions of Lists and BorrowBook module
                Lists.lists()
                BorrowBook.borrow()
            elif(id==3):
                #Calling functions of Lists and ReturnBook module
                Lists.lists()
                ReturnBook.Return()
            elif(id==4):
                #Displaying the message
                print("Thank you for doing business with us!")
                loop=False
            else:
                #executing the else block
                print("Please enter a number from the given choices.\n")
        except ValueError:
            #executing the except block when a error occurs
            print("Invalid! Do not enter anything other than integers.\n")
main()




