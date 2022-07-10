def date():
    import datetime
    #Initializing d with current date and time
    d=datetime.datetime.now
    #Returning current date
    return str(d().date())

def time():
    import datetime
    #Initializing d with current date and time
    d=datetime.datetime.now
    #Returning current time
    return str(d().time())
