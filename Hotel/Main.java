import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList <Hotel> list = new ArrayList <Hotel> () ;
        try{
            File file = new File("allHotels.txt");
            Scanner sc = new Scanner(file);
            String address ;
            int noOfFloors , noOfRooms ;
            while (sc.hasNext()){
                address = sc.next();
                noOfFloors = sc.nextInt();
                noOfRooms = sc.nextInt();
                Hotel h = new Hotel(address, noOfFloors , noOfRooms);
                if (!(list.contains(h)))
                   list.add(h);
                else
                   System.out.println("Hotel already exist");
            }
            sc.close();
        }catch(Exception e){
            System.out.println(e);
        }

        int max = -1 ; 
        Hotel maximumNoOfRooms = null;
        for (Hotel x : list)
           if (x.getonOfFloors() > max){
            maximumNoOfRooms = x;
            max = x.getonOfFloors();
           }
        Collections.sort(list);
        System.out.println("the machine that has the maximum number of rooms: " + maximumNoOfRooms);
        for (Hotel x: list)
           System.out.println(x);
        
    }

}
