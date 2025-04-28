import java.util.*;
import java.io.*;

public class Flight {
    private ArrayList<Passenger> passengers;

    public Flight() {
        passengers = new ArrayList<>();
    }

    public void addDataFormFile(String fileName) {
        String passportNo, lastName;
        char gender;

        try {
            File f = new File(fileName);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                passportNo = sc.next();
                lastName = sc.next();
                gender = sc.next().charAt(0);
                Passenger x = new Passenger(passportNo, lastName, gender);
                if (!(passengers.contains(x)))
                    passengers.add(x);
                else
                    System.out.println("already exist");

            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int genderFrequency(char gender) {
        int counter = 0;
        for (Passenger x : passengers) {
            if (x.getgender() == (gender))
                counter++;
        }
        return counter;
    }

    public void printSorted() {
        Collections.sort(passengers);
        for (Passenger x : passengers) {
            System.out.println(x);
        }
    }

}
