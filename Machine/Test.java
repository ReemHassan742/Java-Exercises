
import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<WashingMachine> list1 = new ArrayList<>();
        try {
            File f = new File("machines.txt");
            Scanner sc = new Scanner(f);
            String brandName;
            int productionYear, capacity;
            while (sc.hasNext()) {
                brandName = sc.next();
                productionYear = sc.nextInt();
                capacity = sc.nextInt();
                WashingMachine w = new WashingMachine(brandName, productionYear, capacity);
                if (!(list1.contains(w)))
                    list1.add(w);
                else
                    System.out.println("washing machine already exist");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        int max = -1;
        WashingMachine maxCapacity = null;
        for (WashingMachine x : list1)
            if (x.getCapacity() > max) {
                maxCapacity = x;
                max = x.getCapacity();
            }
        Collections.sort(list1);
        System.out.println("Maximum washing machine capacity is: " + maxCapacity);
        for (WashingMachine x : list1)
            System.out.println(x);
    }
}