package pr23;

public class LinkedQueue extends AbstractQueue {
    private Node head;
    private Node tail;

    // Внутренний класс для узла списка
    private static class Node {
        Object element;
        Node next;

        Node(Object element) {
            this.element = element;
        }
    }

    public LinkedQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(Object element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.element;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object element = head.element;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return element;
    }
}
