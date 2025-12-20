//this code for the student Management /mini system project
//# mini project
package SystemProjects;

import javax.print.attribute.standard.MediaSize;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.util.*;

public class Student {

    int RollNum;
    String Name;

    public Student(int Roll, String Name) {
        RollNum = Roll;
        this.Name = Name;
    }

    int GetRoll() {
        return RollNum;
    }

    String GetName() {
        return Name;
    }

    static void Menue() {
        System.out.println("1) Attendance Student");
        System.out.println("2) Display Student List");
        System.out.println("3 Search Student");
        System.out.println("4) Remove Student");
        System.out.println("5 Exit..");
    }

    @Override
    public boolean equals(Object obj) {
        Student that = (Student) obj;
        return RollNum == that.RollNum;
    }

    @Override
    public String toString() {
        return RollNum + " | " + Name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(RollNum);
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Set<Student> students = new HashSet();

            System.out.println("<<<<<<<<<<<<<<- VARICON SOFTECH ->>>>>>>>>>>>>>");

            while (true) {

                System.out.print("Enter your Choice : ");
                int Choice = sc.nextInt();

                switch (Choice) {

                    case 1:
                        System.out.println();
                        System.out.println("--------------> Input Form <--------------");

                        System.out.print("Enter the Student Roll Number : ");
                        int RollNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter the Student Full Name : ");
                        String Name = sc.nextLine();

                        Student std = new Student(RollNo, Name);
                        if (students.add(std)) {
                            System.out.println("Roll No " + RollNo + " Successfully Attendance Marked");
                        } else {
                            System.out.println("Student Aleready Attendance Marked !");
                        }
                        System.out.println();

                        break;

                    case 2:

                        System.out.println("----------------< Present Student List >---------------");
                        System.out.print("Enter the Pin For Display All Student : ");
                        int pin = sc.nextInt();
                        if (pin == 8600) {
                            if (students.isEmpty()) {
                                System.out.println("Student Attendance List IS Empty !");
                            } else {
                                int i = 0;
                                for (Student st : students) {
//                            System.out.println(st);
                                    System.out.println("Attend No = [" + (i + 1) + "]");
                                    System.out.println("Roll No : " + st.GetRoll());
                                    System.out.println("Name : " + st.GetName());
                                    System.out.println("-------------------------------------------------");
                                    i++;
                                }
                            }
                        }else {
                            System.out.println("Pin is Wrong !");
                        }
                        System.out.println();

                        break;


                    case 3:
                        System.out.println("----------------> Search Student <---------------");

                        System.out.println("Enter the Student Roll Number : ");
                        int Rolln = sc.nextInt();

                        if (students.isEmpty()) {
                            System.out.println("List Is Empty !");
                        } else {
                            for (Student fin : students) {
                                if (fin.GetRoll() == Rolln) {
                                    System.out.println("Roll No " + Rolln + " is Present");
                                    System.out.println("Roll No : " + fin.GetRoll() + "\n" + "Name : " + fin.GetName());
                                } else {
                                    System.out.println("Roll Number " + Rolln + " is Not Present !");

                                }
                            }
                        }
                        System.out.println();
                        break;

                    case 4:
                        System.out.println("--------------< Removing Student >-------------");
                        System.out.println("Enter the Student Roll Number : ");
                        int Roll = sc.nextInt();

                        if (students.isEmpty()) {
                            System.out.println("Student Attendance List IS Empty !");
                        } else {
                            Iterator<Student> i1 = students.iterator();
                            while (i1.hasNext()) {
                                if (i1.next().RollNum == Roll) {
                                    i1.remove();
                                    System.out.println("Student Removed !");
                                } else {
                                    System.out.println("Student is Not Present !");
                                }
                            }
                        }
                        System.out.println();

//                    Student RemStudent = new Student(Roll,"");
//
//                    if(students.isEmpty()){
//                        System.out.println("Student Attendance List IS Empty !");
//                    } else if(students.remove(RemStudent)){
//                        System.out.println("Student is Removed !");
//                    }
                        break;

                    case 5:
                        return;

                    default:
                        System.out.println("Enter correct Input");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Missmatch !");
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Carefully Focus on System Work !");
        }


    }
}
