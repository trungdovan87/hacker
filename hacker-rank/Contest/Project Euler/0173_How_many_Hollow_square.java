/**
 * Project Euler #173: Using up to one million tiles how many different "hollow" square laminae can be formed
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler173
 * point: 100/100
 */

import java.util.*;

/**
 * Solution: a ^ 2 - b ^ 2 <= n
 * a = b + k (k is even)
 * => b <= (n/k - k) / 2
 */
public class Main {
  void run() {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    System.out.println(resolve(n));
  }

  long calculateB(long n, long k) {
    return (long) ( (double) n / k  - k ) / 2;
  }

  long resolve(long n) {
    long result = 0;
    long top = (long) Math.sqrt(n);
    for (long i = 2; i <= top; i += 2) {
      long b = calculateB(n, i);
      if (b >= 1) {
        result += b;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
