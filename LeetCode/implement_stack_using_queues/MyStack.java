package LeetCode.implement_stack_using_queues;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    private final Queue<Integer> queue;
    private final Queue<Integer> subQueue;

    public MyStack() {
        queue = new ArrayDeque<>();
        subQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        while (queue.size() > 1) {
            subQueue.add(queue.poll());
        }
        int num = queue.poll();
        while (!subQueue.isEmpty()) {
            queue.add(subQueue.poll());
        }
        return num;
    }

    public int top() {
        while (queue.size() > 1) {
            subQueue.add(queue.poll());
        }
        int num = queue.poll();
        subQueue.add(num);
        while (!subQueue.isEmpty()) {
            queue.add(subQueue.poll());
        }
        return num;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
