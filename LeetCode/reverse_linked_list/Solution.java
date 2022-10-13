package LeetCode.reverse_linked_list;

class Solution {
	public ListNode reverseList(ListNode head) {
		return reverse(head, null);
	}

	public ListNode reverse(ListNode node, ListNode prev) {
		if (node == null) return prev;
		ListNode next = node.next;
		node.next = prev;
		return reverse(next, node);
	}
}
