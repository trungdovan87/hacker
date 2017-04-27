/*
    link: https://www.hackerearth.com/challenge/competitive/april-circuits-17/algorithm/fredo-and-maths-1/
    point: 74/10
*/

#include <iostream>
using namespace std;

bool debug = true;

long phi(long n)
{
    double result = n;   // Initialize result as n
 
    // Consider all prime factors of n and for every prime
    // factor p, multiply result with (1 - 1/p)
    for (long p=2; p*p<=n; ++p)
    {
        // Check if p is a prime factor.
        if (n % p == 0)
        {
            // If yes, then update n and result
            while (n % p == 0)
                n /= p;
            result *= (1.0 - (1.0 / (double) p));
        }
    }
 
    // If n has a prime factor greater than sqrt(n)
    // (There can be at-most one such prime factor)
    if (n > 1)
        result *= (1.0 - (1.0 / (double) n));
 
    return (long)result;
}

long phi2(long n)
{    
    long result = n;   // Initialize result as n
 
    // Consider all prime factors of n and subtract their
    // multiples from result
    for (long p=2; p*p<=n; ++p)
    {
        // Check if p is a prime factor.
        if (n % p == 0)
        {
            // If yes, then update n and result 
            while (n % p == 0)
                n /= p;
            result -= result / p;
        }
    }
 
    // If n has a prime factor greater than sqrt(n)
    // (There can be at-most one such prime factor)
    if (n > 1)
        result -= result / n;
    return result;
}

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

// long findMod1(long x, long m) {
//     int mod = 1;
//     for (int i = 1; i <= m - 1; i++) {
//         mod = nhanMod(mod, x, m);
//         if (mod == 1)
//             return i;
//     }
//     throw 10;
// }

long f(long x, long k, long m) {
    if (k == 0)
        return 1;
    long index = phi2(m);
    if (index == 1)
        return 1;        
    return muMod(x, f(x, k - 1, index), m);
}

long calculate(long x, long k, long m) {
    if (x % m == 0)
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
    cin.ignore();
    cin.ignore();
    return 0;
}
