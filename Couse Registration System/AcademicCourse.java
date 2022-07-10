public class AcademicCourse extends Course
{
    private String LecturerName;
    private String Level;
    private String Credit;
    private String StartingDate;
    private String CompletionDate;
    private int NumberOfAssessments;
    private boolean IsRegistered;
    public AcademicCourse(String CourseID, String Coursename, int Duration, String Level, String Credit, int NumberOfAssessments)
    {
        super(CourseID, Coursename, Duration);
        this.Level=Level;
        this.NumberOfAssessments=NumberOfAssessments;
        this.Credit=Credit;
        LecturerName="";
        StartingDate="";
        CompletionDate="";
        IsRegistered=false;
    }
    
    public String getLecturerName()
    {
        return LecturerName;
    }
    
    public String getLevel()
    {
        return Level;
    }
    
    public String getCredit()
    {
        return Credit;
    }
    
    public String getStartingDate()
    {
        return StartingDate;
    }
    
    public String getCompletionDate()
    {
        return CompletionDate;
    }
    
    public int getNumberOfAssessments()
    {
        return NumberOfAssessments;
    }
    
    public boolean getIsRegistered()
    {
        return IsRegistered;
    }
    
    public void setLecturerName(String Lecturer_Name)
    {
        this.LecturerName=Lecturer_Name;
    }
    
    public void setNumberOfAssessments(int Number_Of_Assessments)
    {
        this.NumberOfAssessments=Number_Of_Assessments;
    }
    
    public void Register(String LecturerName, String CourseLeader, String StartingDate, String CompletionDate)
    {
        if(IsRegistered==true)
        {
            System.out.println("The Academic Course is Registered");
            System.out.println("Lecturer Name is " +LecturerName);
            System.out.println("StartingDate is " +StartingDate);
            System.out.println("CompletionDate is " +CompletionDate);
        }else{
            super.setCourseleader(CourseLeader);
            this.LecturerName=LecturerName;
            this.StartingDate=StartingDate;
            this.CompletionDate=CompletionDate;
            IsRegistered=true;
        }
    }
    
    public void display()
    {
        super.Display();
        if(IsRegistered==true)
        {
            System.out.println("Lecturer Name is "+LecturerName);
            System.out.println("Level is "+Level);
            System.out.println("Credit is "+Credit);
            System.out.println("Number of Assessments is "+NumberOfAssessments);
            System.out.println("Starting Date is "+StartingDate);
            System.out.println("Completion Date is "+CompletionDate);
        }
    }
    
}
