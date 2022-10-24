import sys

a, b = map(int, sys.stdin.readline().split())

A = list(map(int, sys.stdin.readline().split()))
A.sort()
B = {}
for num in (map(int, sys.stdin.readline().split())):
    B[num] = True

ans = []
for num in A:
    if num not in B:
        ans.append(num)

if len(ans) == 0:
    print(0)

else:
    print(len(ans))
    print(*ans, sep=" ")
