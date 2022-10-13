package LeetCode.reverse_linked_list;

class Solution2 {
	public ListNode reverseList(ListNode head) {
		ListNode next;
		ListNode prev = null;

		while (head != null) {
			next =head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
