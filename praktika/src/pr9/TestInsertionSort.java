package pr9;

public class TestInsertionSort {
    public static void main(String[] args) {
        Student[] students = {
                new Student(105,333),
                new Student(102,333),
                new Student(108,333),
                new Student(101,333)
        };

        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        InsertionSort.sortById(students);

        System.out.println("\nAfter sorting:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
