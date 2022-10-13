from typing import Optional

from LeetCode.merge_two_sorted_lists import ListNode


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
       node, prev = head, None

       while node:
           next, node.next = node.next, prev
           prev, node = node, next

       return prev