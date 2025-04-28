public class Passenger implements Comparable<Passenger> {
    private String passportNo;
    private String lastName;
    private char gender;

    public Passenger() {
    }

    public Passenger(String passportNo, String lastName, char gender) {
        this.passportNo = passportNo;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getpassportNo() {
        return passportNo;
    }

    public String getlastName() {
        return lastName;
    }

    public char getgender() {
        return gender;
    }

    public void setpassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public void setgender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passport number: " + passportNo + ", Last name" + lastName + ", gender" + gender;
    }

    public boolean equals(Object obj) {
        Passenger p = (Passenger) obj;
        return (passportNo.equals(p.passportNo) && lastName.equals(p.lastName) && gender == p.gender);

    }

    public int compareTo(Passenger p) {
        return (this.passportNo.compareTo(p.passportNo));
    }
}