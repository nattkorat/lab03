package ex8;

public class TestQueueFrom2Stacks {
    public static void main(String[] args) {
        QueueFrom2Stacks<Integer> queueFrom2Stacks = new QueueFrom2Stacks<>();
        queueFrom2Stacks.enqueue(1);
        queueFrom2Stacks.enqueue(5);

        System.out.println("Que is empty: " + queueFrom2Stacks.isEmpty());
        System.out.println("Size of queue: " + queueFrom2Stacks.size());
        System.out.println("Take the first data from queue: " + queueFrom2Stacks.dequeue());
        System.out.println("Updated size of queue: " + queueFrom2Stacks.size());
        System.out.println("Take the second data from queue: " + queueFrom2Stacks.dequeue());

        // will print "Queue is empty!"
        try {
            System.out.println("Take the empty data from queue" + queueFrom2Stacks.dequeue());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Que is empty: " + queueFrom2Stacks.isEmpty());
    }
}
