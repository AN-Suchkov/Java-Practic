package pr23;

public class ArrayQueue1 extends AbstractQueue {
    private Object[] queue;
    private int head;
    private int tail;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue1() {
        queue = new Object[DEFAULT_CAPACITY];
        head = 0;
        tail = 0;
    }

    public void enqueue(Object element) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        queue[tail] = element;
        tail = (tail + 1) % queue.length;
        size++;
    }

    public Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[head];
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object element = queue[head];
        head = (head + 1) % queue.length;
        size--;
        return element;
    }
}
