public class Test {
    public static void main(String[] args) {
        Flight myFlight = new Flight();
        myFlight.addDataFormFile("passengers.txt");
        System.out.println("Frequency is: " + myFlight.genderFrequency('M'));
        myFlight.printSorted();
    }

}
