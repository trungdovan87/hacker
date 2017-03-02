/**
 * Project Euler #12: Highly divisible triangular number
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler012
 * point: 100/100
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  int numberOfFactor(int n) {
    List<Integer> factor = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      int sum = 0;
      while (n % i == 0) {
        n = n / i;
        sum++;
      }
      if (sum > 0)
        factor.add(sum);
    }
    int result = 1;
    for (int i : factor)
      result = result * (i + 1);
    return result;
  }

  void run() {
    int maxK = 41040;
    int[] result = new int[maxK + 1];
    for (int i = 1; i <= maxK; i++) {
      int t = (i * (i + 1)) / 2;
      result[i] = numberOfFactor(t);
    }

    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int a0 = 0; a0 < T; a0++) {
      int N = scanner.nextInt();
      for (int j = 1; j < result.length; j++) {
        if (result[j] > N) {
          System.out.println((j * (j + 1)) / 2);
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    new Main().run();
  }
}