import collections
from typing import Optional

from LeetCode.palindrome_linked_list import ListNode


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        dq = collections.deque()

        if not head:
            return True

        node = head
        while node is not None:
            dq.append(node.val)
            node = node.next

        while len(dq) > 1:
            if dq.popleft() != dq.pop():
                return False

        return True
