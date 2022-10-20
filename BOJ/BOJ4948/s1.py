import sys

m = 123456
primes = [True for _ in range(2 * m + 1)]
primes[0] = primes[1] = False
count = [0 for _ in range(2* m + 1)]

for i in range(2, int((2*m)**0.5)):
    if not primes:
        continue
    for j in range(2 * i, 2*m+1, i):
        if primes:
            primes[j] = False

for i in range(2, 2*m + 1):
    if primes[i]:
        count[i] = count[i-1] + 1
    else:
        count[i] = count[i-1]

while True:
    n = int(sys.stdin.readline())
    if n == 0:
        break

    print(count[2 * n] - count[n])