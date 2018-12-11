"""
Shuffle Card
Have n card from 0 to (n - 1)
we have k step:
- suffle card at (step) position

Print t card from end

==============
format input:
n t k
a[0..k-1]
with n < 10^9
t, k < 2000

==============
Example
input:
8 7 4
2 5 4 3

output:
7 0 1 2 3 4 5

"""

import sys

def my_input():
    global n, t, k, a
    inp = list(map(int, input().split()))
    n = inp[0]
    t = inp[1]
    k = inp[2]
    a = list(map(int, input().split()))

def worse_input():
    global n, t, k, a
    n = 1_000_000_000
    t = 2000
    k = 2000
    a = []
    for i in range(0, k):
        a.append(2500)

def cal(index):
    global n, t, a
    for s in a:
        if index >= n -s:
            index = index - (n - s) 
        else:
            index = s + index
        # print(index)
    return index

def process():
    global n, t, a       
    a = list(reversed(a))
    for i in range(n - t, n):
        print(cal(i)) 

def run():
    # my_input()
    worse_input()
    process()

if __name__ == "__main__":
    run()
    