package pr11;

import java.util.*;

public class ListPerformanceComparison {

    private static final int ELEMENT_COUNT = 100_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("ArrayList:");
        testPerformance(arrayList);

        System.out.println("\nLinkedList:");
        testPerformance(linkedList);
    }

    private static void testPerformance(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Время добавления: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            list.add(0, i);
        }
        endTime = System.nanoTime();
        System.out.println("Время вставки в начало: " + (endTime - startTime) / 1_000_000 + " ms");

        // Замер времени поиска элемента
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            list.contains(i);
        }
        endTime = System.nanoTime();
        System.out.println("Время поиска: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            list.remove(0);
        }
        endTime = System.nanoTime();
        System.out.println("Время удаления из начала: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
