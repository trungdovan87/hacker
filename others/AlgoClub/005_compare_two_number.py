"""
- Title: Compare Number
- We have an number with format:
(a^b * c^d) / (e^f * g^h)
- Compare 2 number A1, A2 with above format

- Input: contain 2 lines:
a1 b1 c1 d1 e1 f1 g1 h1
a2 b2 c2 d2 e2 f2 g2 h2

(Any number is positive integer and < 10^9)

- Output:
If A1 > A2 print 1
If A1 < A2 print -1
If A1 == A2 print 0

- Example:
Input
5 1 8 3 3 3 2 2
6 5 2 1 3 2 4 3

Output:
-1

"""

import sys
from math import log, fabs

_ALPHA = 1e-10

def ln(a):
    return log(a[0]) * a[1] + log(a[2]) * a[3] - log(a[4]) * a[5] - log(a[6]) * a[7]

def run():
    a1 = list(map(int, input().split()))
    a2 = list(map(int, input().split()))    
    result = ln(a1) - ln(a2)
    print(0) if fabs(result) < _ALPHA else print(1) if result > 0 else print(-1)

if __name__ == "__main__":
    run()
    
