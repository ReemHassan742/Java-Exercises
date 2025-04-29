import java.util.*;
import java.io.*;

public class Section {
    private ArrayList<Student> students;

    public Section() {
        students = new ArrayList<>();
    }

    public void addDataFromFile(String fileName) {
        String passportNo, lastName;
        char gender;
        try {
            File f = new File(fileName);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                passportNo = sc.next();
                lastName = sc.next();
                gender = sc.next().charAt(0);
                Student x = new Student(passportNo, lastName, gender);
                if (!(students.contains(x)))
                    students.add(x);
                else
                    System.out.println("student already exist");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int genderFrequency(char gender) {
        int counter = 0;
        for (Student x : students) {
            if (x.getGender() == (gender))
                counter++;
        }
        return counter;
    }

    public void printSorted() {
        Collections.sort(students);
        for (Student x : students) {
            System.out.println(x);
        }
    }
}