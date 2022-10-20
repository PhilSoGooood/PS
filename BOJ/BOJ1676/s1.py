import sys

N = int(sys.stdin.readline())

ans = 0
for i in range(5, N+1, 5):
    num = i
    while num % 5 == 0:
        ans += 1
        num /= 5

print(ans)