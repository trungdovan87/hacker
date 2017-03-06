/**
 * Project Euler #174: Counting the number of "hollow" square laminae that can form one, two, three, ... distinct arrangements
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler174
 * point: 50/100. Because of Timeout (heavy input, output)
 * Please, use C++
 */

import java.util.Scanner;

/**
 * Solution: a ^ 2 - b ^ 2 <= n
 * a = b + k (k is even)
 * => b <= (n/k - k) / 2
 */
public class Main {
  int MAX = 1000000;
  private int[] calTypeArray() {
    int TOP = (int) Math.sqrt(MAX);
    int[] types = new int[MAX + 1];
    for (int k = 2; k <= TOP; k += 2) {
      int b2 = 2;
      while (true) {
        int product = k * (k + b2);
        if (product > MAX)
          break;
        types[product]++;
        b2 += 2;
      }
    }
    return types;
  }
  int[] types;
  int[] result;
  long init() {
    types = calTypeArray();
    result = new int[MAX + 1];
    for (int i = 1; i <= MAX; i++) {
      if (types[i] >= 1 && types[i] <= 10) {
        result[i] = result[i-1] + 1;
      } else {
        result[i] = result[i-1];
      }
    }
    return 1;
  }


  void run() {
    init();
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int[] input = new int[MAX + 1];
    for (int i = 0; i < t; i++) {
      int k = in.nextInt();
      System.out.println(result[k]);
    }
  }

  public static void main(String[] args) {
    new Main().run();
  }

}
