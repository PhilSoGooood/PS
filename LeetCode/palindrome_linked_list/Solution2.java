package LeetCode.palindrome_linked_list;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
	public boolean isPalindrome(ListNode head) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.addLast(head.val);
		while (head.next != null) {
			head = head.next;
			deque.addLast(head.val);
		}
		while (deque.size() > 1) {
			if (deque.pollFirst() != deque.pollLast()) return false;
		}
		return true;
	}
}



