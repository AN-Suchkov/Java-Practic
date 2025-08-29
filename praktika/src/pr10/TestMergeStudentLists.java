package pr10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestMergeStudentLists {
    public static void main(String[] args) {
        // Создаем два списка студентов
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("Ivan", "Petrov", "Computer Science", 2, "CS-20", 4.5));
        list1.add(new Student("Maria", "Ivanova", "Mathematics", 3, "MTH-21", 3.8));
        list1.add(new Student("Alex", "Sidorov", "Physics", 1, "PHY-19", 4.2));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("Anna", "Smirnova", "Biology", 4, "BIO-18", 4.9));
        list2.add(new Student("Sergey", "Kozlov", "Chemistry", 2, "CHE-20", 3.6));
        list2.add(new Student("Dmitry", "Fedorov", "Engineering", 1, "ENG-19", 4.1));

        System.out.println("List 1:");
        MergeStudentLists.printStudents(list1);

        System.out.println("\nList 2:");
        MergeStudentLists.printStudents(list2);

        // Объединяем и сортируем по фамилии
        List<Student> mergedList = MergeStudentLists.mergeAndSort(list1, list2, Comparator.comparing(Student::getLastName));
        System.out.println("\nMerged and Sorted List (by Last Name):");
        MergeStudentLists.printStudents(mergedList);

        // Объединяем и сортируем по GPA (убывание)
        mergedList = MergeStudentLists.mergeAndSort(list1, list2, Comparator.comparing(Student::getGpa).reversed());
        System.out.println("\nMerged and Sorted List (by GPA, descending):");
        MergeStudentLists.printStudents(mergedList);
    }
}
