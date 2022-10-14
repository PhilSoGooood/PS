from typing import Optional

from LeetCode.add_two_numbers import ListNode


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        root = head = ListNode(0)

        carry = 0
        while l1 or l2 or carry:
            sum = 0

            if l1:
                sum += l1.val
                l1 = l1.next
                
            if l2:
                sum += l2.val
                l2 = l2.next

            carry, val = divmod(sum + carry, 10)
            head.next = ListNode(val)
            head = head.next

        return root.next
