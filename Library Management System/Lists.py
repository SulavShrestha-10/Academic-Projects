#Creating empty Lists
Books=[]
Author=[]
Quantity=[]
Price=[]
def lists():
    #Opening library text in read mode
    f=open("Library.txt","r")
    read=f.readlines()
    #Removing new lines from the file
    read=[a.strip("\n") for a in read]
    for i in range(len(read)):
        #Initializing variable x
        x=0
        for j in read[i].split(","):
            #append j in Books in case if true
            if(x==0):
                Books.append(j)
            #append j in Author in case elif true
            elif(x==1):
                Author.append(j)
            #append j in Quantity in case elif true
            elif(x==2):
                Quantity.append(j)
            #append j in Price in case elif true
            elif(x==3):
                Price.append(j.strip("$"))
            #Add 1 in x
            x=x+1

    



