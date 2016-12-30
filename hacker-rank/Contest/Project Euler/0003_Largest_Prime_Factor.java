/**
 * Project Euler #3: Largest prime factor
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler003
 * point: 100/100
 */

import java.util.*;

public class Main {

	void run() {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			System.out.println(largestPrimeFactor(n));
		}
	}

	long divide(long n, long k) {
		while (n % k == 0) {
			n = n / k;
		}
		return n;
	}

	private long largestPrimeFactor(long n) {
		long k = 2;
		while (k <= Math.floor(Math.sqrt(n))) {
			n = divide(n, k);
			if (n == 1)
				return k;
			k++;
		}
		return n;
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
