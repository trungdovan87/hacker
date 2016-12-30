/**
 * Project Euler #7: 10001st prime
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler007
 * point: 100/100
 */

import java.util.*;

public class Main {

	void run() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			String s = in.next();
			System.out.println(resolve(n, k, s));
		}
	}

	int resolve(int n, int k, String s) {
		int max = 0;
		for (int i = 0; i <= n - k; i++) {
			int product = 1;
			for (int j = 0; j < k; j++)
				product *= (s.charAt(i + j) - '0');
			if (max < product)
				max = product;
		}
		return max;
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
