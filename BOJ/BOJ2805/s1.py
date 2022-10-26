import sys

N, M = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))
trees.sort()
st = trees[N - 1]
en = 0


def check(n: int) -> bool:
    count = 0
    for l in trees:
        if l - n > 0:
            count += (l - n)

    return count >= M


while st > en:
    mid = (st + en + 1) // 2

    if check(mid):
        en = mid
    else:
        st = mid - 1


print(en)
