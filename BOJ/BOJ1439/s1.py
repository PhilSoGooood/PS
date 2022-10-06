import sys

numbers = sys.stdin.readline().rstrip()
ans = 0
prev = ''
for i in numbers:
    if i != prev:
        ans += 1
    prev = i

print(ans // 2)
