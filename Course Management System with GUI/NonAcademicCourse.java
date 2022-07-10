public class NonAcademicCourse extends Course
{
    private String InstructorName;
    private int Duration;
    private String StartDate;
    private String CompletionDate;
    private String ExamDate;
    private String Prerequisite;
    private boolean IsRegistered;
    private boolean IsRemoved;
    public NonAcademicCourse(String CourseID,String Coursename,int Duration,String Prerequisite)
    {
        super(CourseID,Coursename,Duration);
        this.Prerequisite=Prerequisite;
        StartDate="";
        CompletionDate="";
        ExamDate="";
        IsRegistered=false;
        IsRemoved=false;
    }
    
    public String getInstructorName()
    {
        return InstructorName;
    }
    
    public String getStartDate()
    {
        return StartDate;
    }
    
    public String getCompletionDate()
    {
        return CompletionDate;
    }
    
    public String getExamDate()
    {
        return ExamDate;
    }
    
    public String getPrerequisite()
    {
        return Prerequisite;
    }
    
    public int getDuration()
    {
        return Duration;
    }
    
    public boolean getIsRegistered()
    {
        return IsRegistered;
    }
    
    public boolean getIsRemoved()
    {
        return IsRemoved;
    }
    
    public void setInstructorName(String Instructor_Name)
    {
        if(IsRegistered==false)
        {
            this.InstructorName=Instructor_Name;
        }else{
            System.out.println("The non academic course is already registered!");
        }
    }
    
    public void Register(String Courseleader, String InstructorName, String StartDate, String CompletionDate, String ExamDate)
    {
        if(IsRegistered==false)
        {
            setInstructorName(InstructorName);
            super.setCourseleader(Courseleader);
            this.StartDate=StartDate;
            this.CompletionDate=CompletionDate;
            this.ExamDate=ExamDate;
            IsRegistered=true;
        }else{
            System.out.println("The course is already registered");
        }
    }
        
    public void Remove()
    {
        if(IsRemoved==true)
        {
            System.out.println("The course is removed");
        }else{
            super.setCourseleader("");
            InstructorName="";
            StartDate ="";
            CompletionDate ="";
            ExamDate ="";
            IsRegistered=false;
            IsRemoved =true;
        }
    }
    public void display()
    {
        //Using super to call the display method from parent class.
        super.display();
        /*Using conditonal statement to check boolean value of IsRegistered.
        In case of true, the method displays Instructor name, startdate, completion date 
        and exam date.*/
        if(IsRegistered==true)
        {
            System.out.println("Instructor Name = "+InstructorName);
            System.out.println("Start Date = "+StartDate);
            System.out.println("Completion Date = "+CompletionDate);
            System.out.println("Exam Date = "+ExamDate);
            }
        }
    }