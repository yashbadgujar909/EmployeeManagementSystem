//Program of the Bancking System

package SystemProjects;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public abstract class Account {

    private int AcNo;
    private String Name;
    private double Balance;
//    private int AcountType;

    public Account(int Acno,String Name, double Balance){
        AcNo = Acno;
        this.Name = Name;
        this.Balance = Balance;
//        AcountType = AcType;
    }

     int Deposite(int Amount) {
        Balance+=Amount;
        System.out.println("Amount "+Amount+" Rs Successfully Deposited");
         System.out.println("----------------------------------------------");
        return Amount;
    }

    int Widrowal(int Amount){
        Balance-=Amount;
        System.out.println("Ammount "+Amount+" RsSuccessfully Widrow");
        System.out.println("----------------------------------------------");
        return Amount;
    }

    static class SavingAccount extends Account {
        public SavingAccount(int Acno, String Name, double Balance) {
            super(Acno, Name, Balance);
        }
    }

    static class CurrentAccount extends Account {
        public CurrentAccount(int Acno, String Name, double Balance) {
            super(Acno, Name, Balance);
        }
    }

    void Deteils(){
        System.out.println("Account Number  : "+AcNo);
        System.out.println("Act Holder Name : "+Name);
        System.out.println("Account Balance : "+Balance);
    }

    String GetName(){
        return Name;
    }
    @Override
    public String toString() {
        return AcNo+" | "+Name+" | "+Balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Map<Integer, Account> account = new HashMap<>();

            System.out.println("<<<<<<<<<<<<<<<<<<<- VARICON SOFTECH ->>>>>>>>>>>>>>>>>>>");
            System.out.println("1) Create Account");
            System.out.println("2) Deposite Ammount");
            System.out.println("3) Widrow Amount");
            System.out.println("4) Search User");
            System.out.println("5) Display Accounts");
            System.out.println("6) For Exit");
            System.out.println();

            while (true) {
                System.out.print("Enter your Choice : ");
                int Choice = sc.nextInt();

                switch (Choice) {
                    case 1:
                        System.out.println();
                        System.out.println("---------------------> Input Form <--------------------");
                        sc.nextLine();
                        System.out.print("Enter the Account Number : ");
                        int Number = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter the Holder Name : ");
                        String Name = sc.nextLine();

                        System.out.print("Enter the Balance (0.0) : ");
                        double Balance = sc.nextInt();

                        System.out.println("[1.Saving Account] OR [2.current Account]");
                        System.out.print("Enter Account Type : ");
                        int type = sc.nextInt();
                        Account Ac = (type == 1) ? new SavingAccount(Number, Name, Balance) : new CurrentAccount(Number, Name, Balance);
                        account.put(Number, Ac);
                        if (type == 1) {
                            System.out.println("Saving Account Successfully Created");
                            System.out.println();
                        } else {
                            System.out.println("Current Account Successfully Created");
                            System.out.println();
                        }

                        break;

                    case 2:
//                    System.out.println();
                        System.out.println("-------------------< DEPOSITE AMOUNT >-------------------");
                        System.out.print("Enter Account Number : ");
                        int acNumber = sc.nextInt();

                        System.out.print("Enter Amount to Deposited : ");
                        int Amount = sc.nextInt();

                        if (account.isEmpty()) {
                            System.out.println("Account is Empty !");
                        } else {
                            account.get(acNumber).Deposite(Amount);
                        }
                        System.out.println();
                        break;

                    case 3:
//                    System.out.println();
                        System.out.println("-------------------< WIDROW AMOUNT >-------------------");
                        System.out.print("Enter Account Number : ");
                        int AcNumber = sc.nextInt();

                        System.out.print("Enter the Amount to Widrowal : ");
                        int amount = sc.nextInt();

                        if (account.isEmpty()) {
                            System.out.println("Account is Empty !");
                        } else {
                            account.get(AcNumber).Widrowal(amount);
                        }
                        System.out.println();
                        break;

                    case 4:
                        System.out.print("Enter Account Number which you search :");
                        int num = sc.nextInt();
                        if(account.isEmpty()) {
                            System.out.println("Account is Empty !");
                        }else {
                            System.out.println("User is Found");
                            Account ac = account.get(num);
                            ac.Deteils();
                        }
                        System.out.println();
                        break;
                        
                    case 5:
                        System.out.println("-------------------< DISPLAY ALL ACCOUNTS >-------------------");
                        int i = 0;
                        if (account.isEmpty()) {
                            System.out.println("Account is Empty !");
                        } else {
                            for (Account ac : account.values()) {
                                System.out.println("User - (" + (i + 1) + ")");
                                ac.Deteils();
                                System.out.println("----------------------------------------------");
                                i++;
                            }
                        }

                        System.out.println();
                        break;

                    case 6:
                        sc.nextLine();
                        System.out.println("Are you sure to Exit yes/no : ");
                        String Input = sc.nextLine();

                        if (Input.equalsIgnoreCase("Yes")) {
                            System.out.println("EXIT..!");
                            System.out.println("Thanks From Varicon Softech");
                            return;
                        } else {
                            System.out.println("Exiting Cancelled");
                        }
                        break;

                    default:
                        System.out.println("Enter Correct Choice !");
                }
        }
        } catch(NullPointerException e){
            System.out.println("Object Is Null");
        } catch (InputMismatchException e) {
            System.out.println("Input Missmatch !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Carfully Focus On System Work !");
        }

    }
}
