/**
 * Project Euler #174: Counting the number of "hollow" square laminae that can form one, two, three, ... distinct arrangements
 * https://www.hackerrank.com/challenges/recursive-digit-sum
 * point: 100/100
 */

import java.util.*;

public class Main {

  long supperDigit(long p) {
    if (p / 10 == 0)
      return p;
    return p % 10 + supperDigit(p / 10);
  }

  long calculate(long p) {
    if (p < 10)
      return p;
    return calculate(supperDigit(p));
  }

  void run() {
    Scanner scanner = new Scanner(System.in);
    long sum = 0;
    String s = scanner.next();

    for (int i = 0; i < s.length(); i++)
      sum += s.charAt(i) - '0';
    int k = scanner.nextInt();
    System.out.println(calculate(sum * k));
  }

  public static void main(String[] args) {
    new Main().run();
  }

}
