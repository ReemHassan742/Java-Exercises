public class Test {
    public static void main(String[] args) {
        Hotel myHotel = new Hotel();
        myHotel.addDataFromFile("rooms.txt");
        System.out.println("Frequency is: " + myHotel.priceFrequency(40));
        myHotel.printSorted();
    }
}