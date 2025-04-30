public class Main {
    public static void main(String[] args) {
        Laundry dry = new Laundry();

        dry.addDataFromFile("test.txt");
        System.out.println("Frequency is: " + dry.brandFrequency("Bosch"));
        dry.printSorted();
    }

}
