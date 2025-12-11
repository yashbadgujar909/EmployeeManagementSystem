//Just simple employees registration and managment system program with array[] for loopg.  it --version
package SystemProjects;

import javax.naming.Name;
import javax.sound.midi.Soundbank;
import java.lang.classfile.PseudoInstruction;
import java.lang.classfile.attribute.RuntimeVisibleAnnotationsAttribute;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.zip.DeflaterOutputStream;

public class EmployeeSystem {

    private int Id;
    private String Name;
    private String JobTitle;
    private String Departments;
    private double Salery;
    private String City;
    private double Experience;

    public EmployeeSystem(String Name, String JobTitle, String Departments, double Salery, String City, double Experience, int Id) {
        this.Id = Id;
        this.Name = Name;
        this.JobTitle = JobTitle;
        this.Departments = Departments;
        this.Salery = Salery;
        this.City = City;
        this.Experience = Experience;
    }

    String GetName() {
        return Name;
    }

    String GetJobTitle() {
        return JobTitle;
    }

    double GetSalery() {
        return Salery;
    }

    String GetCity() {
        return City;
    }

    double GetExperience() {
        return Experience;
    }

    String GetDepartment() {
        return Departments;
    }

    int GetId() {
        return Id;
    }

    void EmployeeDeteil() {
        System.out.println("EMP-ID = " + Id);
        System.out.println("Name = " + GetName().toUpperCase());
        System.out.println("Designation = " + GetJobTitle());
        System.out.println("Salery = " + Salery);
        System.out.println("City = " + GetCity().toUpperCase());
        System.out.println("Experience = " + Experience);


//          System.out.printf("%-7d | %-15s | %-15s | %-10.2f | %-10s | %-5.1f\n",
//                  Id, Name.toUpperCase(), JobTitle, Salery, City.toUpperCase(), Experience);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<<<<<<<<<<<<-- VARICON SOFTECH -->>>>>>>>>>>>>>");

        try {
        System.out.print("Enter the System ID : ");
        String ID1 = sc.next();
        System.out.print("Enter the System PIN : ");
        int PIN = sc.nextInt();


            if (ID1.equalsIgnoreCase("Admin0102") && PIN == 8600) {
                System.out.println("Intered [" + ID1 + "] and [" + PIN + "] is Correct");
                System.out.println();

//                try {
                    boolean Again = true;
                    while (Again) {

                        System.out.print("Enter Length of EMP Which you Add (0) : ");
                        int size = sc.nextInt();
                        System.out.println();
                        sc.nextLine();
                        EmployeeSystem employee[] = new EmployeeSystem[size];

                        for (int i = 0; i < size; i++) {

                            System.out.println("------------------> INPU FORM <------------------");
                            System.out.println("[EMP-ID = " + (i + 1) + "]");

                            System.out.print("Enter Generated EMP-ID : ");
                            int Id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter the Employee First & Last Name : ");
                            String Name = sc.nextLine();

                            System.out.print("Enter the Designation of Employee : ");
                            String JobTitle = sc.nextLine();

                            System.out.print("Enter the Department : ");
                            String Department = sc.nextLine();

                            System.out.print("Enter the Salery : ");
                            double Salery = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Enter the City : ");
                            String City = sc.nextLine();

                            System.out.print("Enter the Experience in (0.0): ");
                            double Experience = sc.nextDouble();
                            sc.nextLine();

                            System.out.println();

                            employee[i] = new EmployeeSystem(Name, JobTitle, Department, Salery, City, Experience, Id);

                        }


                        System.out.println("<<<<<<<<<<<<<- EMP-Details / Registration Receipt ->>>>>>>>>>>>");

                        for (int i = 0; i < employee.length; i++) {
                            System.out.println();
                            employee[i].EmployeeDeteil();
                        }
                        System.out.println();


                        System.out.println("<<<<<<<<<<<<<<<- EMPLOYEE MANAGMENT ->>>>>>>>>>>>>>>");
                        //departments
                        System.out.println("- Employees in HR Department");
                        for (int h = 0; h < employee.length; h++) {
                            if (employee[h].GetDepartment().equalsIgnoreCase("Hr")) {
                                System.out.println("[EMP-ID = " + (h + 1) + "] = " + employee[h].GetName());
                            }
                        }
                        System.out.println();


                        System.out.println("- Employees in IT Department");
                        for (int j = 0; j < employee.length; j++) {
                            if (employee[j].GetDepartment().equalsIgnoreCase("It")) {
                                System.out.println("[EMP-ID = " + (j + 1) + "] = " + employee[j].GetName());
                            }
                        }
                        System.out.println();

                        //jobtitle
                        System.out.println("- Employees on Designing or Devolopment Role");
                        for (int a = 0; a < employee.length; a++) {
                            if (employee[a].GetJobTitle().equalsIgnoreCase("Designer") || employee[a].GetJobTitle().equalsIgnoreCase("Devoloper")) {
                                System.out.println("[EMP-ID = " + (a + 1) + "] = " + employee[a].Name);
                            }
                        }
                        System.out.println();


                        System.out.println("- Employees on DataAnylist or AiMl Role");
                        for (int m = 0; m < employee.length; m++) {
                            if (employee[m].GetJobTitle().equalsIgnoreCase("DataAnylist") || employee[m].GetJobTitle().equalsIgnoreCase("AiMl")) {
                                System.out.println("[EMP-ID = " + (m + 1) + "] = " + employee[m].Name);
                            }
                        }
                        System.out.println();

                        //city/office
                        System.out.println("- Employees Of Pune Office");
                        for (int k = 0; k < employee.length; k++) {
                            if (employee[k].GetCity().equalsIgnoreCase("Pune")) {
                                System.out.println("[EMP-ID = " + (k + 1) + "] = " + employee[k].GetName());
                            }
                        }
                        System.out.println();


                        System.out.println("- Employees of Banglore Office");
                        for (int l = 0; l < employee.length; l++) {
                            if (employee[l].GetCity().equalsIgnoreCase("Banglore")) {
                                System.out.println("[EMP-ID = " + (l + 1) + "] = " + employee[l].GetName());
                            }
                        }
                        System.out.println();

                        //experience
                        System.out.println("- Newly/Fresher Employees");
                        for (int v = 0; v < employee.length; v++) {
                            if (employee[v].GetExperience() < 1) {
                                System.out.println("[EMP-ID = " + (v + 1) + "] = " + employee[v].GetName());
                            }
                        }
                        System.out.println();


                        System.out.println("- Old/Senior Employees");
                        for (int n = 0; n < employee.length; n++) {
                            if (employee[n].Experience > 8) {
                                System.out.println("[EMP-ID = " + (n + 1) + "] = " + employee[n].Name);
                            }
                        }
                        System.out.println();


                        boolean RunAgen = true;
                        while (RunAgen) {

                            System.out.print("You want Need Search yes/no : ");
                            String input = sc.nextLine();


                            if (!input.equalsIgnoreCase("Yes")) {
                                RunAgen = true;
                                break;
                            }
//                          else {
//                           RunAgen = false;
//                          }


                            System.out.print("Enter EMP-ID : ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            for (int s = 0; s < employee.length; s++) {
                                if (employee[s].GetId() == id) {
                                    System.out.println("EMP Register : " + "[EMP-ID = " + employee[s].Id + "] = " + employee[s].Name);
                                } else {
                                    System.out.println(id + " = is Not Register");
                                }
                            }
                            System.out.println();

                        }


                        System.out.println();
                        System.out.print("You Want to need Add Employees again Yes/No : ");
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("Yes")) {
                            Again = true;
                        } else if (input.equalsIgnoreCase("No")) {
                            Again = false;
                        } else {
                            System.out.print("Thanks From Varicon Softech");
                            Again = false;
                        }
                        System.out.println();

                    }  //outer while loop bracket

            } else {
                System.out.println();
                System.out.println("["+ ID1 + "] and [" + PIN + "] is Wrong !");
                System.out.println("Cheak ID or PIN !");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Missmatch !");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


    }
}
