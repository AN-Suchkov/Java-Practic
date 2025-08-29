package pr10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeStudentLists {
    // Метод для объединения и сортировки двух списков
    public static List<Student> mergeAndSort(List<Student> list1, List<Student> list2, Comparator<Student> comparator) {
        List<Student> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);

        mergeSort(mergedList, comparator);
        return mergedList;
    }

    // Метод сортировки слиянием
    private static void mergeSort(List<Student> list, Comparator<Student> comparator) {
        if (list.size() > 1) {
            int mid = list.size() / 2;

            List<Student> left = new ArrayList<>(list.subList(0, mid));
            List<Student> right = new ArrayList<>(list.subList(mid, list.size()));

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            merge(list, left, right, comparator);
        }
    }

    private static void merge(List<Student> list, List<Student> left, List<Student> right, Comparator<Student> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    // Метод для вывода списка студентов
    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
