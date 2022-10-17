import sys

N, K = map(int, sys.stdin.readline().split())

comb = [[0] * (N+1) for _ in range(N+1)]

for i in range(1, N+1):
    comb[i][0] = comb[i][i] = 1
    for j in range(1, i):
        comb[i][j] = comb[i-1][j] + comb[i-1][j-1]

print(comb[N][K])