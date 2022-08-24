package LeetCode.linked_list_cycle;

/*
fast 는 한번에 두칸씩, slow 는 한번에 한칸씩 이동해서 만나는 경우 싸이클이 존재.
그렇지 않은 경우는 싸이클이 없다.

반복문의 조건식을 fast != null && fast.next != null 로 한 이유는
fast.next 가 null 이 아니어야 fast.next.next 가 존재하는지 판단할 수 있고, 이때 존재하지 않는 경우
fast == null 이기 때문에 반복문을 탈출하게 되기때문.

 */


public class Solution2 {
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;

			if(fast == slow) return true;
		}

		return false;
	}
}
