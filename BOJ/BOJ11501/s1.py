import sys

T = int(input())
for tc in range(T):
    n = int(sys.stdin.readline())
    price_arr = list(map(int, sys.stdin.readline().split()))
    result = 0
    max_price = 0
    for i in range(n - 1, -1, -1):
        if price_arr[i] > max_price:
            max_price = price_arr[i]
        else:
            result += max_price - price_arr[i]

    print(result)
