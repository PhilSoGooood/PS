import sys

k, n = map(int, sys.stdin.readline().split())
lines = [int(sys.stdin.readline()) for _ in range(k)]

st = 1
end = sys.maxsize

while st < end:
    mid = (st + end + 1) // 2
    cnt = 0
    for l in lines:
        cnt += l // mid

    if cnt >= n:
        st = mid

    else:
        end = mid - 1

print(st)

