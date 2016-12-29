/**
 * Project Euler #1: Multiples of 3 and 5
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler001
 * point: 100/100
 */

import java.util.*;

public class Main {
	long f(int n, int x) {
		long k = (n - 1) / x;
		return (((k + 1) * k) / 2) * x;
	}

	void run() {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			long f3 = f(n, 3);
			long f5 = f(n, 5);
			long f15 = f(n, 15);
			System.out.println(f3 + f5 - f15);
			//System.out.println(f(n, 3) + f(n, 5) - f(n, 15));
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
