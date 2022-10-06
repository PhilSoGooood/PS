package LeetCode.palindrome_linked_list;

class Solution3 {
	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;

		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		ListNode tmp;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			tmp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = tmp;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null && slow.val == prev.val) {
			slow = slow.next;
			prev = prev.next;
		}
		return slow == null;
	}
}



