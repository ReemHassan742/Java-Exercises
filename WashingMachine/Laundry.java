import java.util.*;
import java.io.*;

public class Laundry {
    private ArrayList<WashingMachine> list;

    public Laundry() {
        list = new ArrayList<WashingMachine>();
    }

    public void addDataFromFile(String fileName) {
        String brandName;
        int productionYear;
        int capacity;
        try {
            File f = new File(fileName);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                brandName = sc.next();
                productionYear = sc.nextInt();
                capacity = sc.nextInt();
                WashingMachine x = new WashingMachine(brandName, productionYear, capacity);
                if (!(list.contains(x)))
                    list.add(x);
                else
                    System.out.println("washing machine already exist");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int brandFrequency(String brandName) {
        int counter = 0;
        for (WashingMachine x : list) {
            if (x.getBrandName().equals(brandName))
                counter++;
        }
        return counter;
    }

    public void printSorted() {
        Collections.sort(list);
        for (WashingMachine x : list) {
            System.out.println(x);
        }
    }
}