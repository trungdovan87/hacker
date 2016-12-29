/**
 * Project Euler #168: Number Rotations
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler168/submissions/code/34789148
 * point: 100/100
 */

import java.math.BigInteger;
import java.util.*;

public class Main {

	BigInteger num0 = BigInteger.valueOf(0);
	BigInteger num10 = BigInteger.valueOf(10);
	BigInteger tenPower4 = BigInteger.valueOf(10000);

	// A = [b(10 ^ (n-1) - x)] / (10x - 1)
	BigInteger f(int n, int x, int b) {
		BigInteger bigB = BigInteger.valueOf(b);
		BigInteger bigX = BigInteger.valueOf(x);

		BigInteger above = num10.pow(n - 1);
		above = above.subtract(bigX);
		above = above.multiply(bigB);

		BigInteger below = BigInteger.valueOf(10 * x - 1);

		if (above.mod(below).compareTo(num0) == 0) {
			BigInteger tmp = above.divide(below);
			if (tmp.toString().length() == n - 1)
				return tmp;
			else
				return null;
		} else {
			return null;
		}
	}

	int process(int m) {
		int result = 0;
		for (int n = 2; n <= m; n++)
			for (int x = 1; x <= 9; x++)
				for (int b = 1; b <= 9; b++) {
					BigInteger tmp = f(n, x, b);
					if (tmp != null) {
						//System.out.println(tmp.toString() + b);
						int lt = tmp.mod(tenPower4).intValue() * 10 + b;
						result = (result + lt) % 100000;
					}
				}
		return result;
	}

	void run() {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(process(m));
		scanner.close();
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
