public class Course
{
    private String CourseID;
    private String CourseName;
    private String Courseleader;
    private int CourseDuration;

    public Course(String CourseID, String CourseName, int CourseDuration)
    {
        this.CourseID = CourseID;
        this.CourseName = CourseName; 
        this.CourseDuration = CourseDuration;
        Courseleader = "";
    }
    
    public String getCourseID()
    {
        return CourseID;
    }
    
    public String getCourseName()
    {
        return CourseName;
    }
    
    public String getCourseLeader()
    {
        return Courseleader;
    }
    
    public int getCourseDuration()
    {
        return CourseDuration;
    }
    
    public void setCourseleader(String Courseleader)
    {
        this.Courseleader = "Course Leader is " + Courseleader;
    }
    
    public void display()
    {
        System.out.println("Course ID is " + CourseID);
        System.out.println("Course Name is " + CourseName);
        System.out.println("Course Duration is " + CourseDuration);
        if (Courseleader!="")
        {
            System.out.println("Course Leader is " + Courseleader);
        }
    }
}
    