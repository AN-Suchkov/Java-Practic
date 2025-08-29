package pr23;

public class QueueTest1 {
    public static void main(String[] args) {
        testLinkedQueue();
        testArrayQueue();
    }

    public static void testLinkedQueue() {
        System.out.println("Testing LinkedQueue...");
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        try {
            System.out.println(queue.dequeue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testArrayQueue() {
        System.out.println("Testing ArrayQueue...");
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        try {
            System.out.println(queue.dequeue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}