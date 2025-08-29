package pr17;

public class TesterAll17 {

    public static void main(String[] args) {
        // Тестирование задания 1 - Создание двусвязного циклического списка вставками
        System.out.println("Тест 1: Создание двусвязного циклического списка вставками");
        ListOperations.DoublyLinkedList.createListInsertions(5);
        ListOperations.DoublyLinkedList.createListInsertions(3);
        ListOperations.DoublyLinkedList.createListInsertions(7);
        ListOperations.DoublyLinkedList.createListInsertions(1);
        printList();

        // Тестирование задания 2 - Сортировка списка по минимальному значению
        System.out.println("\nТест 2: Сортировка списка по минимальному значению");
        ListOperations.DoublyLinkedList.sortListByMinValue();
        printList();  // Выводим список после сортировки

        // Тестирование задания 3 - Сортировка списка с перестановкой соседних элементов
        System.out.println("\nТест 3: Сортировка списка с перестановкой соседних элементов");
        ListOperations.DoublyLinkedList.sortListSwapNeighbors();
        printList();  // Выводим список после сортировки

        // Тестирование задания 4 - Вставка строки с сохранением упорядоченности по длине и алфавиту
        System.out.println("\nТест 4: Вставка строки с сохранением упорядоченности");
        ListOperations.DoublyLinkedList.insertStringInOrder("apple");
        ListOperations.DoublyLinkedList.insertStringInOrder("banana");
        ListOperations.DoublyLinkedList.insertStringInOrder("kiwi");
        printList();  // Выводим список после вставки строк

        // Тестирование задания 5 - Вставка значения с сохранением упорядоченности
        System.out.println("\nТест 5: Вставка значения с сохранением упорядоченности");
        ListOperations.DoublyLinkedList.insertValueInArraySorted(4);
        ListOperations.DoublyLinkedList.insertValueInArraySorted(9);
        ListOperations.DoublyLinkedList.insertValueInArraySorted(2);
        printList();  // Выводим список после вставки значений

        // Тестирование задания 6 - Сортировка списка по максимальному значению
        System.out.println("\nТест 6: Сортировка списка по максимальному значению");
        ListOperations.DoublyLinkedList.sortListByMaxValue();
        printList();  // Выводим список после сортировки
    }

    // Метод для вывода списка на экран
    public static void printList() {
        ListOperations.DoublyLinkedList.Node current = ListOperations.DoublyLinkedList.head;
        if (current == null) {
            System.out.println("Список пуст.");
            return;
        }

        System.out.println("Содержимое списка:");
        do {
            System.out.print("[");
            for (int i = 0; i < current.size; i++) {
                System.out.print(current.data[i] + (i < current.size - 1 ? ", " : ""));
            }
            System.out.print("] ");
            current = current.next;
        } while (current != ListOperations.DoublyLinkedList.head);
        System.out.println();
    }

}
