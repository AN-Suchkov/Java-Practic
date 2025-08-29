package pr10;

import java.util.Arrays;
import java.util.Comparator;

public class SortingStudentsByGPA {
    private Student[] iDNumber;

    public SortingStudentsByGPA(int size) {
        iDNumber = new Student[size];
    }

    public void setArray(Student[] students) {
        if (students.length <= iDNumber.length) {
            System.arraycopy(students, 0, iDNumber, 0, students.length);
        } else {
            throw new IllegalArgumentException("Too many students to fit in the array.");
        }
    }

    public void quickSortByGPA(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSortByGPA(low, pivotIndex - 1);
            quickSortByGPA(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        double pivot = iDNumber[high].getGpa();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (iDNumber[j].getGpa() > pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Student temp = iDNumber[i];
        iDNumber[i] = iDNumber[j];
        iDNumber[j] = temp;
    }

    public void mergeSort(Comparator<Student> comparator) {
        if (iDNumber.length > 1) {
            int mid = iDNumber.length / 2;
            Student[] left = Arrays.copyOfRange(iDNumber, 0, mid);
            Student[] right = Arrays.copyOfRange(iDNumber, mid, iDNumber.length);

            SortingStudentsByGPA leftSorter = new SortingStudentsByGPA(left.length);
            SortingStudentsByGPA rightSorter = new SortingStudentsByGPA(right.length);
            leftSorter.setArray(left);
            rightSorter.setArray(right);

            leftSorter.mergeSort(comparator);
            rightSorter.mergeSort(comparator);

            merge(leftSorter.iDNumber, rightSorter.iDNumber, comparator);
        }
    }

    private void merge(Student[] left, Student[] right, Comparator<Student> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                iDNumber[k++] = left[i++];
            } else {
                iDNumber[k++] = right[j++];
            }
        }

        while (i < left.length) {
            iDNumber[k++] = left[i++];
        }

        while (j < right.length) {
            iDNumber[k++] = right[j++];
        }
    }

    public void outArray() {
        for (Student student : iDNumber) {
            System.out.println(student);
        }
    }
}
