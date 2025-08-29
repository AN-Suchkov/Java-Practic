package pr11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private String major;
    private int year;
    private String group;
    private double gpa;
    private Date birthDate;

    public Student(String firstName, String lastName, String major, int year, String group, double gpa, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.year = year;
        this.group = group;
        this.gpa = gpa;
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFormattedBirthDate(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(birthDate);
    }

    // Геттеры и сеттеры для остальных полей
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
        if (year > 0) {
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

    @Override
    public String toString() {
        String birthDateStr = getFormattedBirthDate("dd.MM.yyyy");
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + major + '\'' +
                ", year=" + year +
                ", group='" + group + '\'' +
                ", gpa=" + gpa +
                ", birthDate=" + birthDateStr +
                '}';
    }
}
