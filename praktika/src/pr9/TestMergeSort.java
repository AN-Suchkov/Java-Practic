package pr9;

import java.util.ArrayList;
import java.util.List;

public class TestMergeSort {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(101, 3.4));
        list1.add(new Student(103, 3.7));
        list1.add(new Student(105, 2.9));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(102, 3.6));
        list2.add(new Student(104, 3.5));
        list2.add(new Student(106, 3.8));

        System.out.println("List 1:");
        for (Student student : list1) {
            System.out.println(student);
        }

        System.out.println("\nList 2:");
        for (Student student : list2) {
            System.out.println(student);
        }

        List<Student> merged = MergeSort.merge(list1, list2);

        System.out.println("\nMerged List:");
        for (Student student : merged) {
            System.out.println(student);
        }
    }
}
