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
//    Scanner in = new Scanner(System.in);
//    long n = in.nextLong();
//    System.out.println(resolve(n));
    init();
  }

  long calculateB(long n, long k) {
    return (long) ( (double) n / k  - k ) / 2;
  }

  int calN(int n) {
    int result = 0;
    for (int i = 1; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        int k = n / i;
        if ((k - i) % 2 == 0) {
          int a = (k + i) / 2;
          int b = (k -i ) / 2;
//          System.out.println("i = " + i + ", k = " + k);
          result++;
        }
      }
    }
    return result;
  }

  long init() {
    int MAX = 1000000;
//    MAX = 100000;
    int TOP = (int) Math.sqrt(MAX);
    int[] result = new int[MAX + 1];
    for (int k = 1; k <= TOP; k++) {
      int j = 2;
      while (true) {
        int product = k * (k + j);
        if (product > MAX)
          break;
        result[product]++;
        j += 2;
      }
    }
//    for (int i = 0; i < result.length; i++) {
////      System.out.println("i = " + i + ", kq[i] = " + result[i]);
//      if (result[i] != calN(i)) {
//        System.out.println("wrong i = " + i);
//        System.out.println("result[i] = " + result[i]);
//        System.out.println("N(i) = " + calN(i));
//      }
//    }
    int kq = 0;
    for (int i = 0; i < result.length; i++) {
      if (result[i] == 2) {
//        System.out.println("i : " + i);
        kq++;
      }
    }

    System.out.println("kq: " + kq);
//    System.out.println("N(n) " + calN(15));
    return 1;
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
