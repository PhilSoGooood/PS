import sys

T = int(sys.stdin.readline())

for _ in range(T):
    M, N, x, y = map(int, sys.stdin.readline().split())

    if N == y: y = 0
    for i in range(x, M*N+1, M):
        if i % N == y:
            print(i)
            break

    else:
        print(-1)


