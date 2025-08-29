package pr9;

public class TestQuickSort {
    public static void main(String[] args) {
        Student[] students = {
                new Student(105, 3.2),
                new Student(102, 3.8),
                new Student(108, 2.9),
                new Student(101, 3.5)
        };

        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        SortingStudentsByGPA.quickSort(students, 0, students.length - 1);

        System.out.println("\nAfter sorting:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
