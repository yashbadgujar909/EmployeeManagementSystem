//program for the Hotel Room Booking System /Mini Project Hotel Room Booking System;

package SystemProjects;

import javax.naming.Name;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.RoundingMode;
import java.util.*;

class CustomComparable implements Comparator<Hotel>{
    @Override
    public int compare(Hotel o1, Hotel o2) {
        return o1.RoomNo - o2.RoomNo;
    }
}

public class Hotel {
    int RoomNo;
    String Type;

    public Hotel(int Room, String type){
        RoomNo = Room;
        Type = type;
    }

    @Override
    public String toString() {
        return RoomNo+" | "+Type;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        Hotel that = (Hotel) obj;
        return this.RoomNo == that.RoomNo;
//        return Objects.equals(RoomNo == that.RoomNo ,Type.equalsIgnoreCase(that.Type));
    }

    @Override
    public int hashCode() {
        return Objects.hash(RoomNo);
    }


    static void Manue(){
        System.out.println("1) Add Room");
        System.out.println("2) Book Room");
        System.out.println("3) Room Booked Geust List");
        System.out.println("4) Available and Booked Rooms");
        System.out.println("5) Remove Added Room");
        System.out.println("6) Cancelled Book Room");
        System.out.println("7) Exit..");
        System.out.println();
    }

    static class Room{
        int RoomNo;
        String CustomerName;
        String RoomType;

        public Room(int RoomNo,String RoomTye,String CustomerName){
            this.RoomNo = RoomNo;
            this.RoomType = RoomTye;
            this.CustomerName = CustomerName;
        }

        @Override
        public String toString() {
            return RoomNo+" | "+RoomType+" | "+CustomerName;
        }

        @Override
        public boolean equals(Object obj) {
            Room that = (Room) obj;

//            return Objects.equals(this.RoomNo == that.RoomNo, this.RoomType.equalsIgnoreCase(that.RoomType));
            return this.RoomNo == that.RoomNo && this.RoomType.equalsIgnoreCase(that.RoomType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(RoomNo,RoomType);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Hotel> hotels = new HashSet<>();
        Set<Room> rooms = new HashSet<>();

        System.out.println("<<<<<<<<<<<<<<<<< VARICON SOFTECH >>>>>>>>>>>>>>>>");

        Manue();
        try {
            while (true) {

                System.out.print("Enter your Choice : ");
                int Choice = sc.nextInt();

                switch (Choice) {

                    case 1:

                        System.out.println("-----------------> MANAGER INPUT FORM <-----------------");
                        try {
                            System.out.print("Enter the Room ID : ");
                            int No = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter the Room Type Ac/NonAc : ");
                            String type1 = sc.nextLine();

                            Hotel h1 = new Hotel(No, type1);

                            if (hotels.add(h1)) {
                                System.out.println("Room Added Wit Room ID " + No);
                            } else {
                                System.out.println("Room With Room ID " + No + " Aleready Added !");
                            }
                            System.out.println("-----------------------------------------------------------");
                            System.out.println();
                        } catch (InputMismatchException e) {
                            System.out.println("Input Missmatch !");
                        }
                        break;

                    case 2:

                        System.out.println("-----------------> ROOM BOOKING FORM <----------------");

                        List<Hotel> list = new ArrayList<>(hotels);

                        System.out.println("Available Rooms");
                        Collections.sort(list,new CustomComparable());
                        int i = 0;
                        for (Hotel ho1 : list) {
                            System.out.println((i+1)+") "+"Room ID : "+ho1.RoomNo +" | "+"Room Type : "+ho1.Type);

                            i++;
                        }

                        System.out.println("-------------------------------------------------------");
                        System.out.print("Enter the Room ID : ");
                        int RoomNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Room Type Ac/NoAc : ");
                        String type = sc.nextLine();

                        System.out.print("Enter the Customer Name : ");
                        String Cname = sc.nextLine();

                        if (hotels.isEmpty()) {
                            System.out.println("Room List is Empty !");
                        } else {
                            boolean Eixst = false;
                            for (Hotel ho2 : hotels) {
                                if (ho2.RoomNo == RoomNo && ho2.Type.equalsIgnoreCase(type)) {
                                    Eixst = true;
                                    break;
                                }
                            }
                            if (!Eixst) {
                                System.out.println("Room is Not Exist !");
                                break;
                            }

                            Room room = new Room(RoomNo, type, Cname);

                            if (rooms.contains(room)) {
                                System.out.println("Room is Aleready Booked !");
                            } else {
                                rooms.add(room);
                                System.out.println("Room with ID "+RoomNo+" Successfully Booked");
                            }
                        }
                        System.out.println("-----------------------------------------------------------");
                        System.out.println();
                        break;

                    case 3:

                        System.out.println("----------------< ROOM BOOKED GEUST LIST >-----------------");

                        if (rooms.isEmpty()) {
                            System.out.println("Geust List is Empty !");
                        } else {
                            for (Room ro : rooms) {
                                System.out.println("Room Id : " + ro.RoomNo + "\n" + "Room Type : " + ro.RoomType.toUpperCase() + "\n" + "Guest Name : " + ro.CustomerName.toUpperCase());
                                System.out.println();
                            }
                        }
                        System.out.println("-----------------------------------------------------------");
                        System.out.println();
                        break;


                    case 4:

                        System.out.println();

                        System.out.println("-----------------< AVAILABLE AND BOOKED ROOMS >-----------------");

                        System.out.println("--- AVAILABLE ROOMS ---");

                        if (hotels.isEmpty()) {
                            System.out.println("Room List is Empty !");
                        } else {
                            for (Hotel H1 : hotels) {
                                System.out.println("Room ID : " + H1.RoomNo + " | " + "Room Type : " + H1.Type);
                            }
                        }

                        System.out.println();
                        System.out.println("--- BOOKED ROOM ---");

                        if (rooms.isEmpty()) {
                            System.out.println("Room List is Empty !");
                        } else {
                            for (Room R1 : rooms) {
                                System.out.println("Room ID : " + R1.RoomNo + " | " + "Room Type : " + R1.RoomType);
                            }
                        }
                        System.out.println("-----------------------------------------------------------");
                        break;


                    case 5:

                        System.out.println("-----------------> REMOVE ADDED ROOMS <------------");

                        Iterator<Hotel> i1 = hotels.iterator();
                        System.out.println("Enter the Room ID : ");
                        int id = sc.nextInt();

                        if (hotels.isEmpty()) {
                            System.out.println("Room List is Empty !");
                        } else {


                            while (i1.hasNext()) {
                                Hotel Hotel = i1.next();
                                if (Hotel.RoomNo == id) {
                                    hotels.remove(Hotel);
                                    System.out.println("Room Removed !");
                                }
                            }
                        }
                        System.out.println("-----------------------------------------------------------");

                        break;


                    case 6:
                        System.out.println("-----------------> Cancelled Booked Room <----------------");
                        System.out.print("Enter the Room ID To Booking Cancel : ");
                        int id1 = sc.nextInt();

                        if(rooms.isEmpty()){
                            System.out.println("Room List is Empty !");
                        }else {

                            boolean found = true;

                            Iterator<Room> i2 = rooms.iterator();
                            while (i2.hasNext()){
                                Room r2 = i2.next();
                                if (r2.RoomNo == id1) {

                                    i2.remove();

                                    System.out.println("Room Booking Cancelled !");
                                    found = true;
                                    break;
                                }
                            }
                        }
                        System.out.println("-----------------------------------------------------------");
                        System.out.println();
                        break;

                    case 7:
                        sc.nextLine();
                        System.out.print("Are you sure exit From System yes/no : ");
                        String input = sc.nextLine();

                        if(input.equalsIgnoreCase("yes")) {
                            System.out.println("Exit..");
                            System.out.println("Thanks from Varicon Softech");
                            return;
                        }else {
                            System.out.println("Exiting Cancelled");
                            System.out.println();
                        }
                        break;

                    default:
                        System.out.println("Enter the Correct Choice !");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Missmatch !");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Mr System User Carfully Focus On System Work !");
        }

    }
}
