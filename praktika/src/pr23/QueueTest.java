package pr23;

public class QueueTest {
    public static void main(String[] args) {
        testArrayQueueModule();
        testArrayQueueADT();
        testArrayQueue();
    }

    public static void testArrayQueueModule() {
        System.out.println("Testing ArrayQueueModule...");
        ArrayQueueModule.enqueue(1);
        ArrayQueueModule.enqueue(2);
        System.out.println(ArrayQueueModule.dequeue());
        System.out.println(ArrayQueueModule.dequeue());
        try {
            System.out.println(ArrayQueueModule.dequeue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testArrayQueueADT() {
        System.out.println("Testing ArrayQueueADT...");
        ArrayQueueADT queue = new ArrayQueueADT();
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