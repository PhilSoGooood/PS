import sys


def left_idx(target: int, nums: list):
    st = 0
    end = len(nums)

    while st < end:
        mid = (st + end) // 2
        if nums[mid] >= target:
            end = mid
        else:
            st = mid + 1
    return st


def right_idx(target: int, nums: list):
    st = 0
    end = len(nums)

    while st < end:
        mid = (st + end) // 2
        if nums[mid] > target:
            end = mid
        else:
            st = mid + 1
    return st


N = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()
M = int(sys.stdin.readline())
targets = list(map(int, sys.stdin.readline().split()))

for target in targets:
    st = left_idx(target, nums)
    end = right_idx(target, nums)
    sys.stdout.write(str(end - st) + " ")
