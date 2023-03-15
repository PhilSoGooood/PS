package LeetCode.design_circular_queue;

import java.util.Arrays;

class MyCircularQueue {
    private int[] arr;
    int st = 0;
    int end = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
    }

    public boolean enQueue(int value) {
        if (st == end && arr[end] != -1) return false;
        arr[end++] = value;
        end %= arr.length;
        return true;
    }

    public boolean deQueue() {
        if (arr[st] == -1) return false;
        arr[st++] = -1;
        st %= arr.length;
        return true;
    }

    public int Front() {
        return arr[st];
    }

    public int Rear() {
        if (end - 1 == -1) {
            return arr[arr.length - 1];
        }
        return arr[end - 1];
    }

    public boolean isEmpty() {
        return arr[st] == -1;
    }

    public boolean isFull() {
        return st == end && arr[end] != -1;
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
