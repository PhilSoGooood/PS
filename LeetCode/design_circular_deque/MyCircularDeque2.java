package LeetCode.design_circular_deque;

class MyCircularDeque2 {

    int length = 0;
    int maxLen;
    ListNode head;
    ListNode tail;

    public MyCircularDeque2(int k) {
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        maxLen = k;
    }

    public boolean insertFront(int value) {
        if (length == maxLen) return false;
        ListNode newNode = new ListNode(value);
        ListNode tmp = head.next;
        head.next = newNode;
        newNode.next = tmp;
        newNode.prev = head;
        tmp.prev = newNode;
        length++;
        return true;
    }

    public boolean insertLast(int value) {
        if (length == maxLen) return false;
        ListNode newNode = new ListNode(value);
        ListNode tmp = tail.prev;
        tmp.next = newNode;
        newNode.prev = tmp;
        newNode.next = tail;
        tail.prev = newNode;
        length++;
        return true;
    }

    public boolean deleteFront() {
        if (length == 0) return false;
        ListNode tmp = head.next.next;
        head.next = tmp;
        tmp.prev = head;
        length--;
        return true;
    }

    public boolean deleteLast() {
        if (length == 0) return false;
        ListNode tmp = tail.prev.prev;
        tmp.next = tail;
        tail.prev = tmp;
        length--;
        return true;
    }

    public int getFront() {
        if(length == 0) return -1;
        return head.next.value;
    }

    public int getRear() {
        if(length == 0) return -1;
        return tail.prev.value;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == maxLen;
    }


    static class ListNode {
        ListNode prev;
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
        }
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
