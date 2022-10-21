import sys
from collections import Counter

input = sys.stdin.readline
N = input()
nums = Counter(input().split())
M = input()
ans = [nums[target] for target in input().split()]
print(' '.join(map(str, ans)))
