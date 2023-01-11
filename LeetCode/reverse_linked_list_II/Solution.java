package LeetCode.reverse_linked_list_II;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) return head;

        ListNode root = new ListNode();
        root.next = head;
        int index = 0;
        ListNode start = root;
        while (index++ < left - 1) {
            start = start.next;
        }
        ListNode end = start.next;

        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }
        return root.next;
    }
}
