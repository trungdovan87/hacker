/**
 * Project Euler #9: Special P
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler009
 * point: 100/100
 */

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    new Main().run();
  }

  int calculate(int n, int a) {
    double result = (2.0 * a * a + n * n - 2 * a * n) / (2 * (n - a));
    if (result == (int) result)
      return (int) result;
    else
      return -1;
  }

  int resolve(int n) {
    int max = -1;
    for (int a = 1; a < n; a++) {
      int c = calculate(n, a);
      if (c > 0) {
        int b = n - a - c;
        if (c < (a + b)) {
          int product = a * b * c;
          if (max < product) {
            max = product;
          }
        }
      }
    }
    return max;
  }

  void run() {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      System.out.println(resolve(n));
    }
  }
}
