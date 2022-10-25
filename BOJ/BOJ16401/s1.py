import sys

M, N = map(int, sys.stdin.readline().split())
snacks = list(map(int, sys.stdin.readline().split()))


def check(num: int) -> bool:
    if num == 0:
        return False

    count = sum([n // num for n in snacks])
    if count >= M:
        return True
    else:
        return False


snacks.sort()

st = 1
end = snacks[N - 1]
ans = 0

while st < end:
    mid = (st + end + 1) // 2
    if check(mid):
        st = mid
        ans = mid
    else:
        end = mid - 1

print(ans)
