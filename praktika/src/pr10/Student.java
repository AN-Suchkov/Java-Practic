package pr10;

public class Student {
    private String firstName;
    private String lastName;
    private String major;
    private int year;
    private String group;
    private double gpa;



    public Student(String firstName, String lastName, String major, int year, String group, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.year = year;
        this.group = group;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0) { // Валидация курса
            this.year = year;
        } else {
            throw new IllegalArgumentException("Year must be positive.");
        }
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    // Переопределение toString() для вывода объекта в читабельном формате
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + major + '\'' +
                ", year=" + year +
                ", group='" + group + '\'' +
                ", gpa='" + gpa + '\'' +
                '}';
    }
}
