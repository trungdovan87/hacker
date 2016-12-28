
# long f(long n) {
#         if (n == 0)
#             return 1;
#         if (n % 2 ==0)
#             return f(n / 2) + f(n - 1);
#         return f(n / 2);
#     }

import sys

a = int(sys.stdin.readline().strip())
if a == 0:
    print(1)
    sys.exit(0)

a_bin = bin(a)[2:]
split_idx = len(a_bin) - 1
# initial rewind
while split_idx >= 0:
    if a_bin[split_idx] == '1':
        split_idx -= 1
    else:
        break
prev_split_idx = split_idx
act = 0
pas = 0
first_time = True
while split_idx >= 0:
    # find splitting point
    while split_idx >= 0:
        if a_bin[split_idx] == '1':
            break
        else:
            split_idx -= 1
    num = prev_split_idx - split_idx
    if first_time:
        act = num
        pas = 1
        first_time = False
    else:
        new_pas = pas + act
        new_act = (pas + act) * num + act
        pas = new_pas
        act = new_act
    split_idx -= 1
    prev_split_idx = split_idx
if pas + act == 0:
    print(1)
else:
    print(pas+act)