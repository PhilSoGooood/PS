import sys


def isExist(target: int, nums: list):
    st = 0
    end = len(nums) - 1
    while st <= end:
        mid = int((st + end) / 2)
        if nums[mid] == target:
            return 1
        elif nums[mid] < target:
            st = mid + 1
        else:
            end = mid - 1

    return 0


N = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()
M = int(sys.stdin.readline())
targets = list(map(int, sys.stdin.readline().split()))

for target in targets:
    print(isExist(target, nums))
