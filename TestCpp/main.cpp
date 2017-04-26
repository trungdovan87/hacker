/*
    link: https://www.hackerearth.com/challenge/competitive/april-circuits-17/algorithm/fredo-and-maths-1/
    point: 4/10
*/

#include <iostream>
using namespace std;

bool debug = true;


long sqrMod(long x, long m) {
    return (x * x) % m;
}

long nhanMod(long a, long b, long m) {
    return (a * b) % m;
}

long muMod(long x, long k, long m) {
    if (k == 0)
        return 1;
    x = x % m;
    if (k % 2 == 0) {
        return sqrMod(muMod(x, k / 2, m), m);
    } else {
        return nhanMod(x, sqrMod(muMod(x, k / 2, m), m), m);
    }
}

long findMod1(long x, long m) {
    int mod = 1;
    for (int i = 1; i <= m - 1; i++) {
        mod = nhanMod(mod, x, m);
        if (mod == 1)
            return i;
    }
    throw 10;
}

long f(long x, long k, long m) {
    long index = findMod1(x, m);
    if (index == 1)
        return 1;
    return muMod(x, f(x, k - 1, index), m);
}

long calculate(long x, long k, long m) {
    if (m == 1)
        return 0;
    return f(x, k, m);
}

void input() {
    long T, m, k, x;
    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> x >> k >> m;
        cout<< calculate(x, k, m) << endl;
    }
}

int main()
{
    input();

    return 0;
}
