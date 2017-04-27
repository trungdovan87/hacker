/*
    link: https://www.hackerearth.com/challenge/competitive/april-circuits-17/algorithm/fredo-and-maths-1/
    point: 87/10
*/

#include <iostream>
using namespace std;

bool debug = true;

long power(long x, long y, int p)
{
    long res = 1;      // Initialize result
 
    x = x % p;  // Update x if it is more than or 
                // equal to p
 
    while (y > 0)
    {
        // If y is odd, multiply x with result
        if (y & 1)
            res = (res*x) % p;
 
        // y must be even now
        y = y>>1; // y = y/2
        x = (x*x) % p;  
    }
    return res;
}

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

long f(long x, long k, long m) {
    if (k == 0)
        return 1;
    long index = phi2(m);
    if (index == 1)
        return 1;        
    return power(x, f(x, k - 1, index), m);
}

long calculate(long x, long k, long m) {
    if (m == 1)
        return 0;
    return f(x, k, m);
}

int arr[1000000];
// int arr[20];
int count;
long tinh(long x, long k, long m) {
    if (m == 1)
        return 0;

    count = 1;
    arr[0] = m;
    do {
        arr[count] = phi(arr[count-1]);
        count++;
    } while (arr[count - 1] != 1 && count <= k);
    long tmp = x;
    if (count = 1) {
        return x % m;
    }
    for (int i = count - 1; i >= 1; i--) {
        tmp = power(x, tmp % arr[i], arr[i - 1]);
    }
    return tmp;
}

void input() {
    // cout << tinh(5, 4, 3) << endl;

    long T, m, k, x;    
    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> x >> k >> m;
        // cout<< calculate(x, k, m) << endl;
        cout<< tinh(x, k, m) << endl;
    }
}

int main()
{    
    input();
    cin.ignore();
    cin.ignore();
    return 0;
}
