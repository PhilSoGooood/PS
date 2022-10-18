import sys

N, K = map(int, sys.stdin.readline().split())
numbers = [True] * (N+1)
numbers[0] = numbers[1] = False
count = 0

for i in range(2, N+1):
    if not numbers[i]:
        continue
    numbers[i] = False
    count += 1
    if count == K:
        print(i)
        break

    for j in range(i * 2, N+1, i):
        if not numbers[j]:
            continue
        numbers[j] = False
        count += 1
        if count == K:
            print(j)
            break
