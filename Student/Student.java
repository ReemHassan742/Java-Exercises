public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private char gender;

    public Student() {
    }

    public Student(String id, String name, char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", Name:" + name + ", gender:" + gender;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return (id.equals(student.id) && name.equals(student.name) && gender == student.gender);
    }

    public int compareTo(Student s) {
        return id.compareTo(s.id);
    }
}