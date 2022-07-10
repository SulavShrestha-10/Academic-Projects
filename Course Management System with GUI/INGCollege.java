import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class INGCollege implements ActionListener {
    // Initializing JFrame
    private JFrame frame;
    // Initializing JPanels
    private JPanel p1, p2;
    // Initializing JLabels
    private JLabel acadlabel, nonacadlabel, idlabel, coursenamelabel, durationlabel, lecturerlabel, leaderlabel,
            levellabel, creditlabel, assessmentlabel, nonidlabel, noncourselabel, nondurationlabel, nonprelabel,
            instructorlabel, nonleaderlabel, startdatelabel, comdatelabel, nonstartlabel, noncomlabel, examlabel;
    // Initializing JTextFields
    private JTextField txtid, txtcourse, txtduration, txtassessment, txtlecturer, txtleader, txtlevel, txtcredit,
            txtnonid, txtnoncourse, txtnonduration, txtnonpre, txtinstructor, txtnonleader, txtstartdate, txtcomdate,
            txtnonstartdate, txtnoncomdate, txtnonexamdate;
    // Initializing JButtons
    private JButton addbtn, regbtn, displaybtn, clearbtn, nonaddbtn, nonregbtn, nondisplaybtn, nonremovebtn,
            nonclearbtn, nextbtn, previousbtn;
    ArrayList<Course> al = new ArrayList<Course>();
    // Creating objects of AcademicCourse and NonAcademicCourse
    AcademicCourse objAC;
    NonAcademicCourse objNAC;

    INGCollege() {
        // Adding elements in the GUI using the constructor of the class
        frame = new JFrame("Register Form");
        p1 = new JPanel();
        p2 = new JPanel();

        acadlabel = new JLabel("Academic Course");
        acadlabel.setFont(new Font("Arial", Font.BOLD, 20));
        acadlabel.setBounds(290, 20, 200, 50);
        p1.add(acadlabel);// Adding the label in p1 after giving layout and font

        idlabel = new JLabel("Course ID:");
        idlabel.setBounds(20, 125, 100, 30);
        p1.add(idlabel);// Adding the label in p1 after giving layout

        txtid = new JTextField();
        txtid.setBounds(130, 125, 150, 30);
        p1.add(txtid);// Adding the textfield in p1 after giving layout

        durationlabel = new JLabel("Duration:");
        durationlabel.setBounds(20, 175, 100, 30);
        p1.add(durationlabel);// Adding the label in p1 after giving layout

        txtduration = new JTextField();
        txtduration.setBounds(130, 175, 150, 30);
        p1.add(txtduration);// Adding the textfield in p1 after giving layout

        coursenamelabel = new JLabel("Course Name:");
        coursenamelabel.setBounds(420, 125, 120, 30);
        p1.add(coursenamelabel);// Adding the label in p1 after giving layout

        txtcourse = new JTextField();
        txtcourse.setBounds(550, 125, 150, 30);
        p1.add(txtcourse);// Adding the textfield in p1 after giving layout

        assessmentlabel = new JLabel("Assessments:");
        assessmentlabel.setBounds(420, 175, 120, 30);
        p1.add(assessmentlabel);// Adding the label in p1 after giving layout

        txtassessment = new JTextField();
        txtassessment.setBounds(550, 175, 150, 30);
        p1.add(txtassessment);// Adding the textfield in p1 after giving layout

        levellabel = new JLabel("Level:");
        levellabel.setBounds(20, 225, 120, 30);
        p1.add(levellabel);// Adding the label in p1 after giving layout

        txtlevel = new JTextField();
        txtlevel.setBounds(130, 225, 150, 30);
        p1.add(txtlevel);// Adding the textfield in p1 after giving layout

        creditlabel = new JLabel("Credit:");
        creditlabel.setBounds(420, 225, 120, 30);
        p1.add(creditlabel);// Adding the label in p1 after giving layout

        txtcredit = new JTextField();
        txtcredit.setBounds(550, 225, 150, 30);
        p1.add(txtcredit);// Adding the textfield in p1 after giving layout

        addbtn = new JButton("Add");
        addbtn.setBounds(565, 285, 120, 30);
        p1.add(addbtn);// Adding the button in p1 after giving layout
        addbtn.addActionListener(this);// Adding actionlistener to the button

        leaderlabel = new JLabel("Course Leader:");
        leaderlabel.setBounds(20, 350, 120, 30);
        p1.add(leaderlabel);// Adding the label in p1 after giving layout

        txtleader = new JTextField();
        txtleader.setBounds(130, 350, 150, 30);
        p1.add(txtleader);// Adding the textfield in p1 after giving layout

        lecturerlabel = new JLabel("Lecturer Name:");
        lecturerlabel.setBounds(420, 350, 120, 30);
        p1.add(lecturerlabel);// Adding the label in p1 after giving layout

        txtlecturer = new JTextField();
        txtlecturer.setBounds(550, 350, 150, 30);
        p1.add(txtlecturer);// Adding the textfield in p1 after giving layout

        startdatelabel = new JLabel("Start Date:");
        startdatelabel.setBounds(20, 400, 120, 30);
        p1.add(startdatelabel);// Adding the label in p1 after giving layout

        txtstartdate = new JTextField();
        txtstartdate.setBounds(130, 400, 150, 30);
        p1.add(txtstartdate);// Adding the textfield in p1 after giving layout

        comdatelabel = new JLabel("Completion Date:");
        comdatelabel.setBounds(420, 400, 120, 30);
        p1.add(comdatelabel);// Adding the label in p1 after giving layout

        txtcomdate = new JTextField();
        txtcomdate.setBounds(550, 400, 150, 30);
        p1.add(txtcomdate);// Adding the textfield in p1 after giving layout

        regbtn = new JButton("Register");
        regbtn.setBounds(565, 500, 120, 30);
        p1.add(regbtn);// Adding the button in p1 after giving layout
        regbtn.addActionListener(this);// Adding actionlistener to the button

        displaybtn = new JButton("Display");
        displaybtn.setBounds(20, 575, 120, 30);
        p1.add(displaybtn);// Adding the button in p1 after giving layout
        displaybtn.addActionListener(this);// Adding actionlistener to the button

        clearbtn = new JButton("Clear");
        clearbtn.setBounds(160, 575, 120, 30);
        p1.add(clearbtn);// Adding the button in p1 after giving layout
        clearbtn.addActionListener(this);// Adding actionlistener to the button

        nextbtn = new JButton("Next Page");
        nextbtn.setBounds(550, 575, 150, 30);
        p1.add(nextbtn);// Adding the button in p1 after giving layout
        nextbtn.addActionListener(this);// Adding actionlistener to the button

        nonacadlabel = new JLabel("Non-Academic Course");
        nonacadlabel.setFont(new Font("Arial", Font.BOLD, 20));
        nonacadlabel.setBounds(280, 20, 250, 50);
        p2.add(nonacadlabel);// Adding the label in p2 after giving layout and font

        nonidlabel = new JLabel("Course ID:");
        nonidlabel.setBounds(20, 125, 120, 30);
        p2.add(nonidlabel);// Adding the label in p2 after giving layout

        txtnonid = new JTextField();
        txtnonid.setBounds(130, 125, 150, 30);
        p2.add(txtnonid);// Adding the textfield in p2 after giving layout

        noncourselabel = new JLabel("Course Name:");
        noncourselabel.setBounds(420, 125, 120, 30);
        p2.add(noncourselabel);// Adding the label in p2 after giving layout

        txtnoncourse = new JTextField();
        txtnoncourse.setBounds(550, 125, 150, 30);
        p2.add(txtnoncourse);// Adding the textfield in p2 after giving layout

        nondurationlabel = new JLabel("Duration:");
        nondurationlabel.setBounds(20, 175, 120, 30);
        p2.add(nondurationlabel);// Adding the label in p2 after giving layout

        txtnonduration = new JTextField();
        txtnonduration.setBounds(130, 175, 150, 30);
        p2.add(txtnonduration);// Adding the textfield in p2 after giving layout

        nonprelabel = new JLabel("Prerequisite:");
        nonprelabel.setBounds(420, 175, 120, 30);
        p2.add(nonprelabel);// Adding the label in p2 after giving layout

        txtnonpre = new JTextField();
        txtnonpre.setBounds(550, 175, 150, 30);
        p2.add(txtnonpre);// Adding the textfield in p2 after giving layout

        nonaddbtn = new JButton("Add");
        nonaddbtn.setBounds(565, 250, 120, 30);
        p2.add(nonaddbtn);// Adding the button in p2 after giving layout
        nonaddbtn.addActionListener(this);// Adding actionlistener to the button

        nonleaderlabel = new JLabel("Course Leader:");
        nonleaderlabel.setBounds(20, 325, 120, 30);
        p2.add(nonleaderlabel);// Adding the label in p2 after giving layout

        txtnonleader = new JTextField();
        txtnonleader.setBounds(130, 325, 150, 30);
        p2.add(txtnonleader);// Adding the textfield in p2 after giving layout

        instructorlabel = new JLabel("Instructor Name:");
        instructorlabel.setBounds(420, 325, 120, 30);
        p2.add(instructorlabel);// Adding the label in p2 after giving layout

        txtinstructor = new JTextField();
        txtinstructor.setBounds(550, 325, 150, 30);
        p2.add(txtinstructor);// Adding the textfield in p2 after giving layout

        nonstartlabel = new JLabel("Start Date:");
        nonstartlabel.setBounds(20, 375, 120, 30);
        p2.add(nonstartlabel);// Adding the label in p2 after giving layout

        txtnonstartdate = new JTextField();
        txtnonstartdate.setBounds(130, 375, 150, 30);
        p2.add(txtnonstartdate);// Adding the textfield in p2 after giving layout
        noncomlabel = new JLabel("Completion Date:");
        noncomlabel.setBounds(420, 375, 120, 30);
        p2.add(noncomlabel);// Adding the label in p2 after giving layout

        txtnoncomdate = new JTextField();
        txtnoncomdate.setBounds(550, 375, 150, 30);
        p2.add(txtnoncomdate);// Adding the textfield in p2 after giving layout

        examlabel = new JLabel("Exam Date:");
        examlabel.setBounds(20, 425, 120, 30);
        p2.add(examlabel);// Adding the label in p2 after giving layout

        txtnonexamdate = new JTextField();
        txtnonexamdate.setBounds(130, 425, 150, 30);
        p2.add(txtnonexamdate);// Adding the textfield in p2 after giving layout

        nonregbtn = new JButton("Register");
        nonregbtn.setBounds(420, 500, 120, 30);
        p2.add(nonregbtn);// Adding the button in p1 after giving layout
        nonregbtn.addActionListener(this);// Adding actionlistener to the button

        nonremovebtn = new JButton("Remove");
        nonremovebtn.setBounds(565, 500, 120, 30);
        p2.add(nonremovebtn);// Adding the button in p1 after giving layout
        nonremovebtn.addActionListener(this);// Adding actionlistener to the button

        nondisplaybtn = new JButton("Display");
        nondisplaybtn.setBounds(20, 575, 120, 30);
        p2.add(nondisplaybtn);// Adding the button in p1 after giving layout
        nondisplaybtn.addActionListener(this);// Adding actionlistener to the button

        nonclearbtn = new JButton("Clear");
        nonclearbtn.setBounds(160, 575, 120, 30);
        p2.add(nonclearbtn);// Adding the button in p1 after giving layout
        nonclearbtn.addActionListener(this);// Adding actionlistener to the button

        previousbtn = new JButton("Previous Page");
        previousbtn.setBounds(550, 575, 150, 30);
        p2.add(previousbtn);// Adding the button in p1 after giving layout
        previousbtn.addActionListener(this);// Adding actionlistener to the button

        // Giving size and setting layout of panel p1
        p1.setSize(750, 700);
        p1.setLayout(null);
        p1.setVisible(true);
        // Giving size and setting layout of panel p2
        p2.setSize(750, 700);
        p2.setLayout(null);
        // Giving size and setting layout of frame frame
        frame.setLayout(null);
        frame.setSize(750, 700);
        frame.setVisible(true);
        frame.add(p1);// Adding panel p1 in frame
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextbtn)// Code to be executed when nextbtn is clicked
        {
            p1.setVisible(false);
            p2.setVisible(true);
            frame.add(p2);
        } else if (e.getSource() == previousbtn)// Code to be executed when previousbtn is clicked
        {
            p1.setVisible(true);
            p2.setVisible(false);
        }

        if (e.getSource() == addbtn)// Code to be executed when addbtn is clicked
        {
            // Initializing the variables empty and null
            String courseID = "";
            String course = "";
            int duration = 0;
            String level = "";
            int credit = 0;
            int assessment = 0;
            try// Using try block to check for exceptions
            {
                // Assigining the variables the textfield values using get Text method
                courseID = txtid.getText();
                course = txtcourse.getText();
                duration = Integer.parseInt(txtduration.getText());
                level = txtlevel.getText();
                credit = Integer.parseInt(txtcredit.getText());
                assessment = Integer.parseInt(txtassessment.getText());
                boolean added = false;
                if (courseID.equals(""))// Executing the code if courseID is empty
                {
                    JOptionPane.showMessageDialog(frame, "Enter the Course ID.");
                } else {
                    for (Course obj : al)// Traversing through the arraylist
                    {
                        if (objAC.getCourseID().equals(courseID))// Executing the code if courseID is equals to courseID
                                                                 // of objAC
                        {
                            added = true;
                        }
                    }
                    if (added == false)// Executing the code if added is false
                    {
                        objAC = new AcademicCourse(courseID, course, duration, level, credit, assessment);
                        al.add(objAC);
                        JOptionPane.showMessageDialog(frame, "The course is added.");
                    } else// Executing the else block if the value is true
                    {
                        JOptionPane.showMessageDialog(frame, "The course is already added.");
                    }
                }
            } catch (NumberFormatException Z)// Using the catch block to check for errors
            {
                JOptionPane.showMessageDialog(frame, "Do properly.");
            }
        }

        if (e.getSource() == regbtn)// Code to be executed when regbtn is clicked
        {
            // Initializing the variables empty
            String courseID = "";
            String courseLeader = "";
            String lecturerName = "";
            String startDate = "";
            String completionDate = "";
            try// Using try block to check for exceptions
            {
                // Assigining the variables the textfield values using get Text method
                courseID = txtid.getText();
                courseLeader = txtleader.getText();
                lecturerName = txtlecturer.getText();
                startDate = txtstartdate.getText();
                completionDate = txtcomdate.getText();
                boolean idFound = false;
                for (Course obj : al)// Traversing through the arraylist
                {
                    if (objAC.getCourseID().equals(courseID))// Executing the code if courseID is equals to courseID of
                                                             // objAC
                    {
                        idFound = true;
                        if (obj instanceof AcademicCourse)// Executing the code if obj is object of subclass
                        {
                            AcademicCourse objAC = (AcademicCourse) obj;// downcasting to access the method of subclass
                            if (objAC.getIsRegistered() == true)// Executing the code if getIsRegistered is true
                            {
                                JOptionPane.showMessageDialog(frame, "The course is already registered");
                            } else// Executing the else block if the value is false
                            {

                                objAC.Register(courseLeader, lecturerName, startDate, completionDate);
                                JOptionPane.showMessageDialog(frame, "The course is registered");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "The course ID is incorrect.");
                    }
                }
            } // Using the catch block to check for errors
            catch (NumberFormatException Z) {
                JOptionPane.showMessageDialog(frame, "Do properly.");
            }
        }

        if (e.getSource() == displaybtn)// Code to be executed when displaybtn is clicked
        {
            for (Course obj : al)// Traversing through the arraylist
            {
                if (obj instanceof AcademicCourse)// Executing the code if obj is object of subclass
                {
                    objAC = (AcademicCourse) obj;// downcasting to access the method of subclass
                    objAC.display();
                }
            }
        }
        if (e.getSource() == clearbtn)// Code to be executed when clearbtn is clicked
        {
            // Assigning the textfields values empty string
            txtid.setText("");
            txtcourse.setText("");
            txtduration.setText("");
            txtlevel.setText("");
            txtcredit.setText("");
            txtassessment.setText("");
            txtleader.setText("");
            txtlecturer.setText("");
            txtstartdate.setText("");
            txtcomdate.setText("");
        }

        if (e.getSource() == nonaddbtn)// Code to be executed when nonaddbtn is clicked
        {
            // Initializing the variables empty and null
            String courseID = "";
            String course = "";
            int duration = 0;
            String prerequisite = "";
            try// Using try block to check for exceptions
            {
                // Assigining the variables the textfield values using get Text method
                courseID = txtnonid.getText();
                course = txtnoncourse.getText();
                duration = Integer.parseInt(txtnonduration.getText());
                prerequisite = txtnonpre.getText();
                boolean added = false;
                if (courseID.equals(""))// Executing the code if courseID is empty
                {
                    JOptionPane.showMessageDialog(frame, "Enter the Course ID.");
                } else {
                    for (Course obj : al)// Traversing through the arraylist
                    {
                        if (objNAC.getCourseID().equals(courseID))// Executing the code if courseID is equals to
                                                                  // courseID of objNAC
                        {
                            added = true;
                        }
                    }
                    if (added == false)// Executing the code if added is false
                    {
                        objNAC = new NonAcademicCourse(courseID, course, duration, prerequisite);
                        al.add(objNAC);
                        JOptionPane.showMessageDialog(frame, "The course is added.");
                    } else// Executing the else block if the value is true
                    {
                        JOptionPane.showMessageDialog(frame, "The course is already added.");
                    }
                }
            } catch (NumberFormatException Z)// Using the catch block to check for errors
            {
                JOptionPane.showMessageDialog(frame, "Do properly.");
            }
        }

        if (e.getSource() == nonregbtn)// Code to be executed when nonregbtn is clicked
        {
            // Initializing the variables empty and null
            String courseID = "";
            String courseLeader = "";
            String instructorName = "";
            String startDate = "";
            String examDate = "";
            String completionDate = "";
            try// Using try block to check for exceptions
            {
                // Assigining the variables the textfield values using get Text method
                courseID = txtnonid.getText();
                courseLeader = txtnonleader.getText();
                instructorName = txtinstructor.getText();
                startDate = txtnonstartdate.getText();
                examDate = txtnonexamdate.getText();
                completionDate = txtnoncomdate.getText();
                boolean idFound = false;
                for (Course obj : al)// Traversing through the arraylist
                {
                    if (objNAC.getCourseID().equals(courseID))// Executing the code if courseID is equals to courseID of
                                                              // objNAC
                    {
                        idFound = true;
                        if (obj instanceof NonAcademicCourse)// Executing the code if obj is object of subclass
                        {
                            NonAcademicCourse objNAC = (NonAcademicCourse) obj;// downcasting to access the method of
                                                                               // subclass
                            if (objNAC.getIsRegistered() == true)// Executing the code if getIsRegistered is true
                            {
                                JOptionPane.showMessageDialog(frame, "The course is already registered");
                            } else// Executing the else block if the value is false
                            {

                                objNAC.Register(courseLeader, instructorName, startDate, examDate, completionDate);
                                JOptionPane.showMessageDialog(frame, "The course is registered");
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "The course ID is incorrect.");
                    }
                }
            } catch (NumberFormatException Z)// Using the catch block to check for errors
            {
                JOptionPane.showMessageDialog(frame, "Do properly.");
            }
        }

        if (e.getSource() == nonremovebtn)// Code to be executed when nonremovebtn is clicked
        {
            try// Using try block to check for exceptions
            {
                String courseID = txtnonid.getText();
                for (Course obj : al)// Traversing through the arraylist
                {
                    if (obj.getCourseID().equals(courseID))// Executing the code if courseID is equals to courseID of
                                                           // objNAC
                    {
                        if (obj instanceof NonAcademicCourse)// Executing the code if obj is object of subclass
                        {
                            objNAC = (NonAcademicCourse) obj;// downcasting to access the method of subclass
                            if (objNAC.getIsRemoved() == false)// Executing the code if getIsRemoved is false
                            {
                                objNAC.Remove();
                                JOptionPane.showMessageDialog(frame, "The course is removed.");
                            } else// Executing the else block if the value is true
                            {
                                JOptionPane.showMessageDialog(frame, "The course is already removed");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "The course ID is incorrect.");
                    }

                }
            } // Using the catch block to check for errors
            catch (NumberFormatException Z) {
                JOptionPane.showMessageDialog(frame, "Do properly.");
            }
        }
        if (e.getSource() == nondisplaybtn)// Code to be executed when nonclearbtn is clicked
        {
            for (Course obj : al)// Traversing through the arraylist
            {
                if (obj instanceof NonAcademicCourse)// Executing the code if obj is object of subclass
                {
                    objNAC = (NonAcademicCourse) obj;// downcasting to access the method of subclass
                    objNAC.display();
                }
            }
        }
        if (e.getSource() == nonclearbtn)// Code to be executed when addbtn is clicked
        {
            // Assigning the textfields values empty string
            txtnonid.setText("");
            txtnoncourse.setText("");
            txtnonduration.setText("");
            txtnonpre.setText("");
            txtnonleader.setText("");

            txtinstructor.setText("");
            txtnonstartdate.setText("");
            txtnonexamdate.setText("");
            txtnoncomdate.setText("");
        }
    }

    public static void main(String args[]) {
        new INGCollege();
    }
}
