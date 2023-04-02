package LeetCode.merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode head = new ListNode();
        ListNode tail = head;

        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null) pq.add(tail.next);
        }
        return head.next;
    }
}
