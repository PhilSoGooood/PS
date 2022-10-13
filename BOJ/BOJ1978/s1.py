import sys

N = int(sys.stdin.readline().strip())
numbers = list(map(int, sys.stdin.readline().strip().split()))


def is_prime(n):
    if n == 1:
        return 0
    i = 2
    while i * i <= n:
        if n % i == 0:
            return 0
        i += 1

    return 1


ans = 0
for num in numbers:
    ans += is_prime(num)

print(ans)
