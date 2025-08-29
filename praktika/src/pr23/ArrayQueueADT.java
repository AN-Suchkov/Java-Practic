package pr23;

public class ArrayQueueADT {
    private Object[] queue;
    private int size;
    private int head;
    private int tail;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueueADT() {
        queue = new Object[DEFAULT_CAPACITY];
        size = 0;
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

    public Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object element = queue[head];
        head = (head + 1) % queue.length;
        size--;
        return element;
    }

    public Object element() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[head];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        head = 0;
        tail = 0;
    }
}