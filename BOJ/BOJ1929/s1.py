import sys

M, N = map(int, sys.stdin.readline().strip().split())

numbers = [False, False] + [True] * (N-1)


for i in range(2, int(N**0.5)+1):
    if not numbers[i]: continue

    for j in range(i*i, N+1, i):
        numbers[j] = False

for i in range(M, N+1):
    if numbers[i]:
        print(i)
