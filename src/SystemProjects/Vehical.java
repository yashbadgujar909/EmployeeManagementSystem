//this code for the Parking managment #mini project parkiing managment registration

package SystemProjects;

import javax.sql.rowset.BaseRowSet;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.lang.invoke.VarHandle;
import java.util.*;

public class Vehical {
    int VehicalNumber;
    int VehicalModel;
    String VehicalNameType;
    String OwnerName;

    public Vehical(int Number,int Model,String NameType,String Name){
        VehicalNumber = Number;
        VehicalModel = Model;
        VehicalNameType = NameType;
        OwnerName = Name;
    }

    @Override
    public String toString() {
        return VehicalNumber+"    |    "+VehicalModel+"    |    "+VehicalNameType+"    |    "+OwnerName;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer,Vehical> vehical = new HashMap<>();


        try {
            System.out.print("Enter the System UserName : ");
            String UserName = sc.next();

            System.out.print("Enter the System Pin : ");
            int Pin = sc.nextInt();

            if (UserName.equals("Admin0102") && Pin == 8600) {

                System.out.println("[" + UserName + " & [" + Pin + "] is Correct ");
                System.out.println();

                while (true) {

                    System.out.print("Enter your Choice : ");
                    int Choice = sc.nextInt();

                    switch (Choice) {

                        case 1:

                            System.out.println();
                            System.out.println("----------------> VEHICAL REGISTRATION FORM <-----------------");
                            System.out.print("Enter the Vehical Number : ");
                            int Number = sc.nextInt();
//                    if(vehical.containsKey(Number)){
//                        System.out.println("Vehical Aleready Register !");
//                        break;
//                    }
                            System.out.print("Enter the Vehical Model : ");
                            int Model = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Vehical Name & Type : ");
                            String NameType = sc.nextLine();

                            System.out.print("Enter the Vehical Owner Name : ");
                            String Name = sc.nextLine();


                            if (vehical.containsKey(Number)) {
                                System.out.println("Vehical Aleready Register !");
                                break;
                            } else {
                                Vehical v1 = new Vehical(Number, Model, NameType, Name);
                                vehical.put(Number, v1);
                                System.out.println(Number + "-Vehical Registered in Vijay Narayan Parking Pune");
                            }
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            break;

                        case 2:

                            System.out.println("-----------------> REMOVE REGISTERED VEHIVCAL <----------------");
                            System.out.print("Enter the Vehical Number : ");
                            int number = sc.nextInt();

                            if (vehical.isEmpty()) {
                                System.out.println("Vehcal List is Empty !");
                            } else {
                                boolean found = false;
                                for (Vehical v1 : vehical.values()) {
                                    if (v1.VehicalNumber == number) {
                                        vehical.remove(number);
                                        found = true;
                                        System.out.println("Vehical Removed !");
                                        break;
                                    } else {
                                        System.out.println("Number is not Exist !");
                                    }
                                }
                            }
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            break;

                        case 3:

                            System.out.println("-----------------> PARKED VEHICAL LIST <------------------");

                            if (vehical.isEmpty()) {
                                System.out.println("Vehical List is Empty !");
                            } else {
                                int i = 0;
                                for (Map.Entry<Integer, Vehical> Vehical : vehical.entrySet()) {
                                    System.out.println("REGISTER NO-" + "[" + (i + 1) + "]");
                                    System.out.println("Vehical Number : " + Vehical.getValue().VehicalNumber + "\n" + "Vehical Model : " + Vehical.getValue().VehicalModel + "\n" +
                                            "Vehical Name/Type : " + Vehical.getValue().VehicalNameType + "\n" + "Vehical Owner Name : " + Vehical.getValue().OwnerName);
                                    i++;
                                }
                            }
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            break;

                        case 4:
                            return;

                        default:
                            System.out.println("Enter Correct Choice !");
                    }
                }

            } else {
                System.out.println("Incorrect UserName or Pin !");
                System.out.println("Cheackout UserName or Pin");
            }

        }catch (InputMismatchException e){
            System.out.println("Input Missmatch !");
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
