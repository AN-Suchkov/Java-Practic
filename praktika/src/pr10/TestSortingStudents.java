package pr10;
import java.util.Comparator;

public class TestSortingStudents {
    public static void main(String[] args) {
        Student[] students = getStudents();

        SortingStudentsByGPA sorter = new SortingStudentsByGPA(students.length);
        sorter.setArray(students);

        // Сортировка по GPA (убывание)
        System.out.println("Before sorting by GPA:");
        sorter.outArray();

        sorter.quickSortByGPA(0, students.length - 1);
        System.out.println("\nAfter sorting by GPA:");
        sorter.outArray();

        // Сортировка слиянием по имени
        sorter.setArray(students);
        sorter.mergeSort(Comparator.comparing(Student::getFirstName));
        System.out.println("\nAfter sorting by First Name:");
        sorter.outArray();
    }

    private static Student[] getStudents() {
        Student student1 = new Student("Ivan", "Petrov", "Computer Science", 2, "CS-20",67.3);
        student1.setGpa(4.5);

        Student student2 = new Student("Maria", "Ivanova", "Mathematics", 3, "MTH-21",56.2);
        student2.setGpa(3.8);

        Student student3 = new Student("Alex", "Sidorov", "Physics", 1, "PHY-19",22.3);
        student3.setGpa(4.2);

        Student student4 = new Student("Anna", "Smirnova", "Biology", 4, "BIO-18",97.7);
        student4.setGpa(4.9);

        Student[] students = {student1, student2, student3, student4};
        return students;
    }
}
