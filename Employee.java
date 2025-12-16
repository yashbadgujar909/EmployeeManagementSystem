import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Employee {

   private int Id;
   private String Name;
   private String JobTitle;
    private String Departments;
    private double Salery;
    private String City;
    private double Experience;

    public Employee(int id,String name, String jobtitle, String departments, double salery, String city, double experience){
        Id = id;
        Name = name;
        JobTitle = jobtitle;
        Departments = departments;
        Salery = salery;
        City = city;
        Experience = experience;
    }

    int GetId(){
        return Id;
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

  private void EmployeeDeteils(){
      System.out.println("Employee ID = ["+Id+"]");
      System.out.println("Employee Name : "+Name.toUpperCase());
      System.out.println("Employee Designation : "+JobTitle.toUpperCase());
      System.out.println("Employee Salery : "+Salery);
      System.out.println("Employee City : "+City.toUpperCase());
      System.out.println("Employee Experience : "+Experience);
      System.out.println("-------------------------------------------------------");
  }

  private static void Menue(){
      System.out.println("|------------------ CHOICE OPTION -----------------|");
      System.out.println("1) Add Employee");
      System.out.println("2) Remove Employee");
      System.out.println("3) Display Employee");
      System.out.println("4) Employee in Hr & It Dep");
      System.out.println("5) Emp as Designer and Devoloper");
      System.out.println("6) Emp at Pune & Mumbai Office");
      System.out.println("7) Emp at Hyd & Blr Office");
      System.out.println("8) Senior Employee");
      System.out.println("9) Fresher Employee");
      System.out.println("0) Exiting");
  }

    @Override
    public String toString() {
        return "Employee ID = ["+Id+"]"+"\n"+"Employee Name : "+Name.toUpperCase()+"\n"+"Employee Designation : "+JobTitle.toUpperCase()+
                "\n"+"Employee Salery : "+Salery+"\n"+"Employee City : "+City.toUpperCase()+"\n"+"Employee Experience : "+Experience;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("<<<<<<<<<<<<<<<<<<- VRICON SOFTECH ->>>>>>>>>>>>>>>>>>");
        try {
            System.out.print("Enter the System User Name : ");
            String UseName = sc.nextLine();
            System.out.print("Enter the System Pin : ");
            int Pin = sc.nextInt();

        if(UseName.equals("Admin0102") && Pin == 8600) {
            System.out.println("USENAME-["+UseName+"] PIN-["+Pin+"] is Correct");
            Employee.Menue();
            while (true) {
                System.out.println();
                System.out.print("Enter your Chioce : ");
                int Choice = sc.nextInt();
                switch (Choice) {

                    case 1:
                        System.out.println();
                        System.out.println("--------------------> Input Form <--------------------");
                        sc.nextLine();
                        System.out.print("Enter the Employee ID : ");
                        int Id = sc.nextInt();
                        sc.nextLine();
                    try {

                        System.out.print("Enter the First & Last Name : ");
                        String Name = sc.nextLine();

                        System.out.print("Enter the Designation : ");
                        String JobRole = sc.nextLine();

                        System.out.print("Enter the Department : ");
                        String Department = sc.nextLine();

                        System.out.print("Enter the Salery : ");
                        double Salery = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter the City : ");
                        String City = sc.nextLine();

                        System.out.print("Enter the Experience (0.0) : ");
                        double Experience = sc.nextDouble();
                        boolean Found = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).GetId() == Id) {
                                Found = true;
                                break;
                            }
                        }
                        if (Found) {
                            System.out.println("Id Is Aleready Present !");
                        } else {
                            Employee emp = new Employee(Id, Name, JobRole, Department, Salery, City, Experience);
                            list.add(emp);

                            System.out.println("- Employee Added with Id No = [" + Id + "]");
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Input Missmatch !");
                    }
                        System.out.println("<-------------------------------------------------->");

                        break;


                    case 2:
                        System.out.print("Enter the ID to Remove Employee : ");
                        int RemoveInput = sc.nextInt();

                        boolean Remove = true;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).GetId() == RemoveInput) {
                                Remove = true;
                                list.remove(i);  //taking same input id from the for loop/list
                            }
                        }
                        if (Remove) {
                            System.out.println("Employee with id [" + RemoveInput + "] Removed");
                        } else {
                            System.out.println("Employee with id [" + RemoveInput + "] Not Found !");
                        }

                        break;

                    case 3:
                        System.out.println();
                        System.out.println("|---------------------< Employees Deteils >--------------------|");

                        System.out.print("Enter Pin For Display Employee : ");
                        int pass = sc.nextInt();

                        if (pass == 0001) {
                            if (list.isEmpty()) {
                                System.out.println("List is Empty !");
                                break;
                            } else {
                                for (int i = 0; i < list.size(); i++) {
//                                System.out.println("EMPLOYEE = ("+(i+1)+")");
//                                list.get(i).EmployeeDeteils();
                                    System.out.println(list.get(i));
                                    System.out.println("-------------------------------------------------------");
                                }
                            }
                        } else {
                            System.out.println("Pin is Wrong !");
                        }
                        break;

                    case 4:
                        System.out.println();
                        System.out.println("|------------------< Employees in Hr & It Department >----------------|");
                        if (list.isEmpty()) {
                            System.out.println("List is Empty !");
                        } else {
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).GetDepartment().equalsIgnoreCase("Hr") || list.get(i).GetDepartment().equalsIgnoreCase("It")) {
                                    System.out.println("EMP-ID : " + "[" + list.get(i).GetId() + "] = " + list.get(i).GetName());
                                    System.out.println("-------------------------------------------------------");
                                }
                            }
                        }
                        break;


                    case 5:
                        System.out.println();
                        System.out.println("|------------------< Employees as Designer & Devoloper >----------------|");
                        if (list.isEmpty()) {
                            System.out.println("List is Empty !");
                        } else {
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).GetJobTitle().equalsIgnoreCase("Devoloper") || list.get(i).GetJobTitle().equalsIgnoreCase("Designer")) {
                                    System.out.println("EMP-ID : " + "[" + list.get(i).GetId() + "] = " + list.get(i).GetName());
                                    System.out.println("-------------------------------------------------------");
                                }
                            }
                        }
                        break;

                    case 6:
                        System.out.println();
                        System.out.println("|------------------< Employees in Pune & Mumbai Office >----------------|");

                        if (list.isEmpty()) {
                            System.out.println("List is Empty !");
                        } else {
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).GetCity().equalsIgnoreCase("Pune") || list.get(i).GetCity().equalsIgnoreCase("Mumbai")) {
                                    System.out.println("EMP-ID : " + "[" + list.get(i).GetId() + "] = " + list.get(i).GetName());
                                    System.out.println("-------------------------------------------------------");
                                }
                            }
                        }
                        break;

                    case 7:
                        System.out.println();
                        System.out.println("|------------------< Employees in Hydrabad & Banglore Office >----------------|");

                        if (list.isEmpty()) {
                            System.out.println("List is Empty !");
                        } else {
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).GetCity().equalsIgnoreCase("Hydrabad") || list.get(i).GetCity().equalsIgnoreCase("Banglore")) {
                                    System.out.println("EMP-ID : " + "[" + list.get(i).GetId() + "] = " + list.get(i).GetName());
                                    System.out.println("-------------------------------------------------------");
                                }
                            }
                        }
                        break;

                    case 8:
                        System.out.println("|--------------------< Senior Employees >------------------|");

                        if (list.isEmpty()) {
                            System.out.println("List is Empty !");
                        } else {
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).GetExperience() > 7) {
                                    System.out.println("EMP-ID : " + "[" + list.get(i).GetId() + "] = " + list.get(i).GetName());
                                    System.out.println("-------------------------------------------------------");
                                }
                            }
                        }
                        break;


                    case 9:
                        System.out.println("|--------------------< Fresher Employees >------------------|");

                        if (list.isEmpty()) {
                            System.out.println("List is Empty !");
                        } else {
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).GetExperience() < 1) {
                                    System.out.println("EMP-ID : " + "[" + list.get(i).GetId() + "] = " + list.get(i).GetName());
                                    System.out.println("-------------------------------------------------------");
                                }
                            }
                        }
                        break;

                    case 0:
                        sc.nextLine();
                        System.out.print("Are you sure you want to exit? (Yes/No) :");
                        String input = sc.nextLine();

                        if (input.equalsIgnoreCase("Yes")) {

                            System.out.println("Are you Exit From System !");
                            System.out.println("----------< THANKS FROM VAROCON SOFTECH >---------");
                            return;
                        } else {
                            System.out.println("Exit Cancelled.");
                        }
                        break;

                    default:
                        System.out.print("Enter correct choice");

                }
            }
        }else{
            System.out.println("Cheak User Name or Pin And Enter Correct!");
            System.out.println("USER NAME ["+UseName+"] & PIN ["+Pin+"]");
        }
        }catch(InputMismatchException e){
            System.out.println("Input Missmatch !");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Always Carefully Focus On System Work !");
        }


    }
}
