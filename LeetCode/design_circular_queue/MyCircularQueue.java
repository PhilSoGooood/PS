package LeetCode.design_circular_queue;

import java.util.Arrays;

class MyCircularQueue {
    private int[] arr;
    int st = 0;
    int end = -1;
    int len = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        end = (end + 1) % arr.length;
        arr[end] = value;
        len++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        st = (st + 1) % arr.length;
        len--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[st];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return arr[end];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
