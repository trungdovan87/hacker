/**
 * Project Euler #168: Number Rotations
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler168
 * point: 3/10
 */

/**
 * test #2: m >= 12: correct
 */

/**
 102564
 128205
 142857
 153846
 179487
 205128
 230769

 sum: 1142856
 */

import java.util.*;

public class Main {
	final int MOD = 100000;
	final int fourfive = 45;
	final int exceptions = 42856;

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
		if (n % 6 != 0)
			return mod(11111 * fourfive);
		else
		//if n % 6 == 0
			return mod(11111 * fourfive + exceptions);
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