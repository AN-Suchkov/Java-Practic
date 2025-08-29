package pr17;

import java.util.Arrays;

public class ListOperations {

    public static class DoublyLinkedList {
        protected static Node head = null;

        // Узел двусвязного списка с массивом и указателями на следующий и предыдущий элементы
        static class Node {
            int[] data = new int[5];  // Массив из 5 целых переменных
            int size = 0;              // Количество элементов в массиве
            Node next;
            Node prev;

            // Конструктор, инициализирующий узел с данным значением
            Node(int value) {
                this.data[0] = value;  // Инициализируем первым значением
                this.size = 1;          // Устанавливаем размер 1
            }
        }

        // Задание 1: Создание двусвязного циклического списка вставками
        public static void createListInsertions(int value) {
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                head.next = head; // Циклический указатель
                head.prev = head;
            } else {
                Node last = head.prev;
                last.next = newNode;
                newNode.prev = last;
                newNode.next = head;
                head.prev = newNode;
            }
        }

        // Задание 2: Сортировка списка путём исключения элемента с минимальным значением
        public static void sortListByMinValue() {
            if (head == null) return;

            Node current = head;
            Node minNode = head;
            do {
                if (current.size > 0 && current.data[0] < minNode.data[0]) {
                    minNode = current;
                }
                current = current.next;
            } while (current != head);

            // Удаляем минимальный элемент
            minNode.prev.next = minNode.next;
            minNode.next.prev = minNode.prev;

            // Вставляем минимальный элемент в начало
            minNode.next = head;
            minNode.prev = head.prev;
            head.prev.next = minNode;
            head.prev = minNode;
            head = minNode;
        }

        // Задание 3: Сортировка двусвязного циклического списка с перестановкой соседних элементов
        public static void sortListSwapNeighbors() {
            if (head == null) return;

            Node current = head;
            do {
                if (current.size > 1 && current.data[0] > current.next.data[0]) {
                    // Обмен соседними элементами
                    int temp = current.data[0];
                    current.data[0] = current.next.data[0];
                    current.next.data[0] = temp;
                }
                current = current.next;
            } while (current != head);
        }

        // Задание 4: Включение строки с сохранением упорядоченности по длине и алфавиту
        public static void insertStringInOrder(String str) {
            Node current = head;
            do {
                if (current.size < 5) {
                    current.data[current.size++] = str.length();
                    Arrays.sort(current.data, 0, current.size);
                    return;
                }
                current = current.next;
            } while (current != head);

            Node newNode = new Node(str.length());
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }

        // Задание 5: Включение значения в элемент списка с сохранением упорядоченности
        public static void insertValueInArraySorted(int value) {
            Node current = head;

            do {
                if (current.size < 5) {
                    current.data[current.size++] = value;
                    Arrays.sort(current.data, 0, current.size);
                    return;
                }
                current = current.next;
            } while (current != head);

            Node newNode = new Node(value);
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }

        // Задание 6: Сортировка списка путём исключения максимального элемента
        public static void sortListByMaxValue() {
            if (head == null) return;

            Node current = head;
            Node maxNode = head;
            do {
                if (current.size > 0 && current.data[0] > maxNode.data[0]) {
                    maxNode = current;
                }
                current = current.next;
            } while (current != head);

            // Удаляем максимальный элемент
            maxNode.prev.next = maxNode.next;
            maxNode.next.prev = maxNode.prev;

            // Вставляем максимальный элемент в начало
            maxNode.next = head;
            maxNode.prev = head.prev;
            head.prev.next = maxNode;
            head.prev = maxNode;
            head = maxNode;
        }

        // Задание 7: Рекурсивная сортировка списка
        public static Node recursiveSort(Node node) {
            if (node == null || node.next == null) return node;

            Node lesser = null;
            Node greater = null;
            Node current = node.next;

            // Разделяем на две части
            while (current != null) {
                if (current.data[0] <= node.data[0]) {
                    if (lesser == null) lesser = current;
                    else lesser = lesser.next;
                } else {
                    if (greater == null) greater = current;
                    else greater = greater.next;
                }
                current = current.next;
            }

            // Рекурсивный вызов
            lesser = recursiveSort(lesser);
            greater = recursiveSort(greater);

            // "Склеиваем" части
            return node;
        }
    }

    public static void main(String[] args) {
        // Пример использования методов
        DoublyLinkedList.createListInsertions(5);
        DoublyLinkedList.createListInsertions(3);
        DoublyLinkedList.createListInsertions(7);
        DoublyLinkedList.createListInsertions(1);

        // Вставка и сортировка
        DoublyLinkedList.sortListByMinValue();
        DoublyLinkedList.sortListSwapNeighbors();
        DoublyLinkedList.insertStringInOrder("test");
        DoublyLinkedList.insertValueInArraySorted(10);

        // Вывод или другие операции
    }
}
