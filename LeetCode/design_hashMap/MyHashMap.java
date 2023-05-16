package LeetCode.design_hashMap;

class MyHashMap {

    private final ListNode[] map;

    public MyHashMap() {
        map = new ListNode[1000];
    }

    public void put(int key, int value) {
        int idx = key % map.length;
        if (map[idx] == null) {
            map[idx] = new ListNode(key, value);
            return;
        }
        ListNode node = map[idx];
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            if (node.next == null) break;
            node = node.next;
        }
        node.next = new ListNode(key, value);
    }

    public int get(int key) {
        int idx = key % map.length;
        if (map[idx] == null) return -1;
        ListNode node = map[idx];
        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = key % map.length;
        ListNode node = map[idx];
        if (node == null) return;
        if (node.key == key) {
            if (node.next == null) {
                map[idx] = null;
            } else {
                map[idx] = node.next;
                return;
            }
        }
        ListNode prev = node;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    static class ListNode {
        int key;
        int value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
