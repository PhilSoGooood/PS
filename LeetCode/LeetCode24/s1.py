from typing import Optional

from LeetCode.LeetCode24 import ListNode


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head and head.next:
            node = head.next
            head.next = self.swapPairs(node.next)
            node.next = head
            return node

        return head