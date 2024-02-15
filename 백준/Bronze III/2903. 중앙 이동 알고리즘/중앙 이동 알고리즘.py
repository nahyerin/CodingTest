import sys, math

input = sys.stdin.readline

N = int(input())
result = 2

for i in range(1, N+1):
  result = result + math.pow(2, (i-1))
print(int(result ** 2))