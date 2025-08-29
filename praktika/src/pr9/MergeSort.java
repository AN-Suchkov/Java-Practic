package pr9;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<Student> merge(List<Student> list1, List<Student> list2) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).getIdNumber() <= list2.get(j).getIdNumber()) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }

        return merged;
    }
}
