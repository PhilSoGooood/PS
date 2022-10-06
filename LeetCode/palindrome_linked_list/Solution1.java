package LeetCode.palindrome_linked_list;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
	public boolean isPalindrome(ListNode head) {
		List<Integer> list = new ArrayList<>();
		list.add(head.val);
		while (head.next != null) {
			head = head.next;
			list.add(head.val);
		}
		int left = 0;
		int right = list.size() - 1;
		while (left < right) {
			if (list.get(left) != list.get(right)) return false;
			left++;
			right--;
		}
		return true;
	}
}



