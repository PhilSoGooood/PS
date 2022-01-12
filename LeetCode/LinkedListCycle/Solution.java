package LeetCode.LinkedListCycle;

import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	List<ListNode> check = new ArrayList<>();
	public boolean hasCycle(ListNode head) {
		ListNode cur = head;

		while(cur != null){
			if(check.contains(cur)) return true;
			check.add(cur);
			cur = cur.next;
		}

		return false;
	}
}