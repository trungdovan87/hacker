/*
    link: https://www.hackerearth.com/challenge/competitive/april-circuits-17/algorithm/fredo-and-maths-1/
    point: 48/100
    Timout, please use C++
*/

import java.util.*;

public class Main {
    // set debug = true to log console
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        int T, m, x;
        long k;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            x = scanner.nextInt();
            k = scanner.nextLong();
            m = scanner.nextInt();
            System.out.println(calculate(x, k, m));
        }
    }

    int multipleMod(int a, int b, int m) {
        long tmp = a;
        return (int) ((tmp * b) % m);
    }

    // Link: http://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/
    int power(int x, int y, int p) {
        int res = 1;      // Initialize result

        x = x % p;  // Update x if it is more than or
        // equal to p

        while (y > 0) {
            // If y is odd, multiply x with result
            if ((y & 1) == 1)
                res = multipleMod(res, x, p);
                //res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = multipleMod(x, x, p);
            //x = (x * x) % p;
        }
        return res;
    }

    // Link: http://www.geeksforgeeks.org/eulers-totient-function/
    int phi2(int n) {
        int result = n;   // Initialize result as n

        // Consider all prime factors of n and subtract their
        // multiples from result
        for (int p = 2; p * p <= n; ++p) {
            // Check if p is a prime factor.
            if (n % p == 0) {
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

    int f(int x, long k, int m) {
        if (k == 0)
            return 1;
        int index = phi2(m);
        if (index == 1)
            return 1;
        return power(x, f(x, k - 1, index), m);
    }

    int calculate(int x, long k, int m) {
        if (m == 1)
            return 0;
        return f(x, k, m);
    }
}
