import sys

N = int(sys.stdin.readline())
data = [int(sys.stdin.readline()) for _ in range(N)]

score = data[N-1]
ans = 0
for i in range(N-2, -1, -1):
    if score > data[i]:
        score = data[i]
    else:
        tmp = data[i] - score + 1
        ans += tmp
        score = data[i] - tmp

print(ans)