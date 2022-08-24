package LeetCode.remove_duplicates_from_sorted_list;

class ListNode {
   int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while(current != null){
			if(current.next != null && current.val == current.next.val)
				while(current.next != null && current.val == current.next.val)
					current.next = current.next.next;

			current = current.next;
		}
		return head;
	}
}
