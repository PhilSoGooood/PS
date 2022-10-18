import sys

tc = 1
while True:
    L, P, V = map(int, sys.stdin.readline().split())
    if L == 0 and P == 0 and V == 0:
        break
    q, r = divmod(V, P)
    ans = L * q
    if r < L:
        ans += r
    else:
        ans += L

    print(f"Case {tc}: {ans}")
    tc += 1
