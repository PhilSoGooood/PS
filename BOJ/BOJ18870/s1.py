import sys

N = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
sortedNums = sorted(set(nums))
idx = {}

i = 0
for num in sortedNums:
    if num not in idx:
        idx[num] = i
        i += 1

for num in nums:
    sys.stdout.write(str(idx[num]) + " ")

