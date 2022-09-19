class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 투 포인터를 활용한 방식! 그러나 리스트가 정렬되어 있지 않아
        # 인덱스를 반환하는 해당 문제에서는 사용할 수 없다.

        left, right = 0, len(nums) - 1

        while not left == right:
            if nums[left] + nums[right] < target:
                left += 1
            elif nums[left] + nums[right] > target:
                right -= 1
            else:
                return left, right
