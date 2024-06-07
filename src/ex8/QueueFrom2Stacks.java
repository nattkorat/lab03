package ex8;

import java.util.Stack;

public class QueueFrom2Stacks<T> { // T will replace by Datatype class
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueFrom2Stacks() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(T item) {
        this.stack1.push(item);
    }

    public T dequeue() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}
