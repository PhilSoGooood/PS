import sys


def search(n: int, arr: list, dic: dict):
    for i in range(n - 1, -1, -1):
        for j in range(i - 1, -1, -1):
            if (arr[i] - arr[j]) in dic:
                return arr[i]


N = int(sys.stdin.readline())
nums = [int(sys.stdin.readline()) for _ in range(N)]
nums.sort()

added = {}
for i in range(N):
    for j in range(i + 1):
        added[nums[i] + nums[j]] = True


print(search(N, nums, added))
