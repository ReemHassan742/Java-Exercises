import java.util.*;
import java.io.*;

public class Hotel {
    private ArrayList<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
    }

    public void addDataFromFile(String fileName) {
        int roomNo, numberOfBeds, price;
        try {
            File f = new File(fileName);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                roomNo = sc.nextInt();
                numberOfBeds = sc.nextInt();
                price = sc.nextInt();
                Room x = new Room(roomNo, numberOfBeds, price);
                if (!(rooms.contains(x)))
                    rooms.add(x);
                else
                    System.out.println("Room is already exist");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int priceFrequency(int price) {
        int counter = 0;
        for (Room x : rooms) {
            if (x.getPrice() == (price))
                counter++;
        }
        return counter;
    }

    public void printSorted() {
        Collections.sort(rooms);
        for (Room x : rooms) {
            System.out.println(x);
        }
    }
}