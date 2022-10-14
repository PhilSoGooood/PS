package LeetCode.add_two_numbers;

class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = l1.val + l2.val;
		ListNode head = new ListNode(sum % 10);
		ListNode node = head;
		l1 = l1.next;
		l2 = l2.next;
		while (l1 != null || l2 != null) {
			sum /= 10;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			node.next = new ListNode(sum % 10);
			node = node.next;
		}
		if (sum / 10 != 0) {
			node.next = new ListNode(sum / 10);
		}
		return head;
	}
}
