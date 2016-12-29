/**
 * Project Euler #168: Number Rotations
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler168
 * point: 3/10
 */

/**
 * test #2: m >= 12: correct
 */

/**
 Exception with 6
 102564
 128205
 142857
 153846
 179487
 205128
 230769

 sum: 1142856
 ---------

 Exception with 6
 1012658227848

 */

import java.util.*;

public class Main {
	final int MOD = 100000;
	final int fourfive = 45;
	final int exceptions6 = 42856;
	final int exceptions13 = 27848;

	int mod(int value) {
		return value % MOD;
	}

	int calculate(int n) {
		if (n == 2)
			return mod(11 * fourfive);
		if (n == 3)
			return mod(111 * fourfive);
		if (n == 4)
			return mod( 1111 * fourfive);
		if (n == 5)
			return mod(11111 * fourfive);
		int result = mod(11111 * fourfive);
		if (n % 6 == 0)
			result = mod(result + exceptions6);
		if (n % 13 == 0)
			result = mod(result + exceptions13);
		return result;
	}

	int process(int n) {
		int sum = 0;
		for (int i = 2; i <= n; i++) {
			int valueI = calculate(i);
			sum = mod(sum + valueI);
		}
		return sum;
	}
	void run() {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(process(m));
	}

	public static void main(String[] args) {
		new Main().run();
	}
}