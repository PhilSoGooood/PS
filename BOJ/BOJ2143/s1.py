import bisect
import sys

T = int(sys.stdin.readline())
n = int(sys.stdin.readline())
arr1 = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
arr2 = list(map(int, sys.stdin.readline().split()))

dp1 = [0 for _ in range(n+1)]
dp2 = [0 for _ in range(m+1)]
for i in range(n):
    dp1[i+1] = dp1[i] + arr1[i]
for i in range(m):
    dp2[i+1] = dp2[i] + arr2[i]

part1 = []
part2 = []
for i in range(1, n+1):
    for j in range(i):
        part1.append(dp1[i] - dp1[j])

for i in range(1, m+1):
    for j in range(i):
        part2.append(dp2[i] - dp2[j])

ans = 0
part1.sort()
part2.sort()
for num in part1:
    target = T - num
    l = bisect.bisect_left(part2, target)
    r = bisect.bisect_right(part2, target)
    ans += r - l

print(ans)
