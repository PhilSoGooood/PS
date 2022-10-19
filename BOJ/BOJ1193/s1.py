import sys

X = int(sys.stdin.readline())

count = 0
number = 1
while count + number < X:
    count += number
    number += 1

numerator = 0
denominator = 0

if number % 2 == 0:
    numerator = X - count
    denominator = number + 1 - numerator

else:
    denominator = X - count
    numerator = number + 1 - denominator

print(f"{numerator}/{denominator}")