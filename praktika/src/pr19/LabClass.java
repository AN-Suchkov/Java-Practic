package pr19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LabClass {
    private List<Student> students;

    public LabClass(List<Student> students) {
        this.students = students;
    }

    public LabClass() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        try {
            student.setFullName(student.getFullName());

            students.add(student);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }


    public Student findStudent(String fullName) throws StudentNotFoundException, EmptyStringException {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new EmptyStringException("Имя не может быть пустым.");
        }

        for (Student student : students) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Студент с именем " + fullName + " не найден.");
    }


    public void sortStudentsByAverageScore() {
        students.sort(Comparator.comparingDouble(Student::getAverageScore).reversed());
    }

    public List<Student> getStudents() {
        return students;
    }
}