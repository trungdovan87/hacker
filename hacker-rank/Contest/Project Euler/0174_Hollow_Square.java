/**
 * Project Euler #174: Counting the number of "hollow" square laminae that can form one, two, three, ... distinct arrangements
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler174
 * point: 100/100
 */

/**
 * Solution: a ^ 2 - b ^ 2 <= n
 * a = b + k (k is even)
 * => b <= (n/k - k) / 2
 */
public class Main {
  public static void main(String[] args) {
    new Main().run();
  }

  void run() {
//    Scanner in = new Scanner(System.in);
//    long n = in.nextLong();
//    System.out.println(resolve(n));
    init();
  }

  long calculateB(long n, long k) {
    return (long) ((double) n / k - k) / 2;
  }

  int calType(int n) {
    int result = 0;
    for (int k = 2; k < Math.sqrt(n); k += 2) {
      if (n % k == 0) {
        if (n % k == 0) {
          int b2 = (n / k) - k;
          if (b2 % 2 == 0) {
            int b = b2 / 2;
            int a = b + k;
            System.out.println("i = " + k + ", k = " + b2);
            System.out.println(" a= " + a + ", b = " + b);
            result++;
          }
        }
      }
    }
    return result;
  }

  private int[] calTypeArray() {
    int MAX = 1000000;
//    MAX = 100000;
    int TOP = (int) Math.sqrt(MAX);
    int[] result = new int[MAX + 1];
    for (int k = 2; k <= TOP; k += 2) {
      int b2 = 2;
      while (true) {
        int product = k * (k + b2);
        if (product > MAX)
          break;
        result[product]++;
        b2 += 2;
      }
    }
    return result;
  }

  long init() {

//    for (int i = 0; i < result.length; i++) {
////      System.out.println("i = " + i + ", kq[i] = " + result[i]);
//      if (result[i] != calType(i)) {
//        System.out.println("wrong i = " + i);
//        System.out.println("result[i] = " + result[i]);
//        System.out.println("N(i) = " + calType(i));
//      }
//    }
    int[] result = calTypeArray();
    int kq = 0;
    for (int i = 0; i < result.length; i++) {
      if (result[i] >= 1 && result[i] <= 10) {
        System.out.println("i : " + i);
        kq++;
      }
    }

    System.out.println("kq: " + kq);
    System.out.println("N(n) " + calType(996624));
    return 1;
  }
}
