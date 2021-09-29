package xyz;

public class StudentJava {

    public final String name;
    private final int rollNumber;

    public StudentJava(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public static void printAllStudents(StudentJava[] students) {

        for (StudentJava studentJava: students) {
            System.out.println(studentJava);
        }
    }

    public static void printAllStudentRollNumber(StudentJava[] students) {

        for (StudentJava studentJava: students) {
            System.out.println(studentJava.rollNumber);
        }
    }

    @Override
    public String toString() {
        return "xyz.StudentJava{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }
}
