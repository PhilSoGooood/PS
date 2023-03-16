package LeetCode.design_circular_deque;

class MyCircularDeque {

    int size = 0;
    int st;
    int end=0;
    int maxLen;
    int[] arr;

    public MyCircularDeque(int k) {
        this.arr = new int[k];
        st = k - 1;
        this.maxLen = k;
    }

    public boolean insertFront(int value) {
        if (size == maxLen) return false;
        arr[st] = value;
        st = (st - 1 + maxLen) % maxLen;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == maxLen) return false;
        arr[end] = value;
        end = (end + 1) % maxLen;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) return false;
        st = (st + 1) % maxLen;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) return false;
        end = (end - 1 + maxLen) % maxLen;
        size--;
        return true;
    }

    public int getFront() {
        if(size == 0) return -1;
        return arr[(st + 1) % maxLen];
    }

    public int getRear() {
        if(size == 0) return -1;
        return arr[(end - 1 + maxLen) % maxLen];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxLen;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
