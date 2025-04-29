public class Test {
    public static void main(String[] args) {
        Section mySection = new Section();
        mySection.addDataFromFile("students.txt");
        System.out.println("Frequency is: " + mySection.genderFrequency('F'));
        mySection.printSorted();
    }
}