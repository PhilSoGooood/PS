package LeetCode.add_two_numbers;

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = l1.val + l2.val;
		int quotient = sum / 10;
		int remainder = sum % 10;
		ListNode head = new ListNode(remainder);
		l1 = l1.next;
		l2 = l2.next;
		add(l1, l2, head, quotient);
		return head;
	}

	private void add(ListNode l1, ListNode l2, ListNode head, int n) {
		int sum = 0;
		if (l1 == null && l2 == null && n == 0) {
			return;
		} else if (l1 == null && l2 == null) {
			head.next = new ListNode(n);
			return;
		} else if (l1 == null) {
			sum += l2.val + n;
			l2 = l2.next;
		} else if (l2 == null) {
			sum += l1.val + n;
			l1 = l1.next;
		} else {
			sum = l1.val + l2.val + n;
			l1 = l1.next;
			l2 = l2.next;
		}
		int quotient = sum / 10;
		int remainder = sum % 10;

		ListNode newNode = new ListNode(remainder);
		head.next = newNode;
		add(l1, l2, newNode, quotient);
	}
}
