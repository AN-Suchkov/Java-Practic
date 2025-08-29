package pr23;

public class ArrayQueueModule {
    private static final int DEFAULT_CAPACITY = 10;
    private static Object[] queue;
    private static int size;
    private static int head;
    private static int tail;

    static {
        queue = new Object[DEFAULT_CAPACITY];
        size = 0;
        head = 0;
        tail = 0;
    }


    public static void enqueue(Object element) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        queue[tail] = element;
        tail = (tail + 1) % queue.length;
        size++;
    }


    public static Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object element = queue[head];
        head = (head + 1) % queue.length;
        size--;
        return element;
    }


    public static Object element() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[head];
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        size = 0;
        head = 0;
        tail = 0;
    }
}