import sys

N = int(sys.stdin.readline())
cards = list(map(int, sys.stdin.readline().split()))
card = {}

for i in range(N):
    card[cards[i]] = i

M = int(sys.stdin.readline())
targets = list(map(int, sys.stdin.readline().split()))

for i in range(M):
    if targets[i] in card:
        print(1, end=" ")
        
    else:
        print(0, end=" ")
