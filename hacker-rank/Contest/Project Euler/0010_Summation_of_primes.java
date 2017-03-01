/**
 * Project Euler #10: Summation of primes
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler010
 * point: 100/100
 */

import java.util.*;

public class Main {
  List<Integer> primeList;

  public static void main(String[] args) {
    new Main().run();
  }

  boolean checkPrime(int k) {
    for (int i : primeList) {
      if (k % i == 0)
        return false;
      if (i > Math.sqrt(k))
        return true;
    }
    return true;
  }

  SortedMap<Integer, Long> calculateResultMap() {
    primeList = new ArrayList<>();
    primeList.add(2);
    for (int i = 3; i <= 1000000; i++) {
      if (checkPrime(i))
        primeList.add(i);
    }
    long sum = 0;
    SortedMap<Integer, Long> resultMap = new TreeMap<>();
    for (int i : primeList) {
      sum += i;
      resultMap.put(i, sum);
    }
    return resultMap;
  }

  void run() {
    SortedMap<Integer, Long> resultMap = calculateResultMap();
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      int key = resultMap.headMap(n + 1).lastKey();
      System.out.println(resultMap.get(key));
    }
  }
}
