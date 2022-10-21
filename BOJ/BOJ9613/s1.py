import sys

t = int(sys.stdin.readline())


def gcd(a: int, b: int):
    if b == 0:
        return a
    return gcd(b, a % b)


for tc in range(t):
    nums = list(map(int, sys.stdin.readline().split()))
    ans = 0
    for i in range(1, len(nums)):
        for j in range(i + 1, len(nums)):
            ans += gcd(nums[i], nums[j])
    print(ans)
